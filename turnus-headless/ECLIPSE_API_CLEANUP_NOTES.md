# Eclipse API Cleanup Documentation

## Summary

The migration to a pure Maven headless version requires removing all Eclipse Platform APIs while keeping EMF (Eclipse Modeling Framework). This document tracks the status and required actions.

## Status

### ✅ COMPLETED - Simple Cleanups

#### 1. EcoreUtils.java
**Location**: `turnus-common/src/main/java/turnus/common/util/EcoreUtils.java`

**Removed**:
- `getProject(String name)` method - used Eclipse workspace APIs (IProject, IWorkspaceRoot, ResourcesPlugin)
- Javadoc references to IFile and IProject in method comments
- Empty method stub for `getSourceFolders(IProject)` 

**Kept**: All File and URI-based methods for loading/storing EObjects

**Result**: ✅ No more Eclipse Platform API usage in this file

#### 2. FileUtils.java
**Location**: `turnus-common/src/main/java/turnus/common/util/FileUtils.java`

**Removed**:
- Several empty Javadoc method comments that referenced IFile (methods were already deleted, only comments remained)

**Kept**: All actual implementation methods using java.io.File

**Result**: ⚠️ Still has import and usage of Configuration class (see below)

#### 3. Activator.java
**Location**: `turnus-common/src/main/java/turnus/common/Activator.java` and `turnus-model/src/main/java/turnus/model/Activator.java`

**Action**: Deleted both files (OSGi BundleActivator not needed in headless version)

**Result**: ✅ Complete

---

## ❌ BLOCKED - Non-Trivial Issues

### Configuration Class Missing

**Problem**: The `Configuration` class was deleted because it had Eclipse debug.core dependencies (ILaunchConfiguration). However, it's actually used by other files:

#### Files That Need Configuration Class:

1. **TurnusConstants.java** (line 37)
   ```java
   import turnus.common.configuration.Configuration.LaunchConfigurationParser;
   ```
   - Uses: References inner class `LaunchConfigurationParser` in Javadoc
   - Impact: Compilation error

2. **FileUtils.java** (lines 59, 285)
   ```java
   import turnus.common.configuration.Configuration;
   
   public static File createOutputDirectory(String analysisName, Configuration configuration) {
       if (!configuration.hasValue(TurnusOptions.TRACE_FILE)) {
           throw new TurnusException("...");
       }
       File dir = configuration.getValue(TurnusOptions.TRACE_FILE);
       // ... creates directory structure based on configuration
   }
   ```
   - Uses: Imports Configuration, uses it as method parameter, calls `hasValue()`, `getName()`, `getValue()`
   - Impact: Compilation error

---

## Required Actions

### Option A: Recreate Configuration Class Without Eclipse Dependencies (Recommended for full functionality)

**Original Configuration.java** had:
- Eclipse dependency: `org.eclipse.debug.core.ILaunchConfiguration` 
- Inner class: `LaunchConfigurationParser` - parses Eclipse launch configurations
- Core functionality: Key-value store for analysis configuration options

**Action Plan**:
1. Copy `turnus.common/src/turnus/common/configuration/Configuration.java` from original source
2. Remove the `LaunchConfigurationParser` inner class entirely (lines ~193-235 in original)
3. Remove import: `org.eclipse.debug.core.ILaunchConfiguration`
4. Remove any methods that take `ILaunchConfiguration` as parameter
5. Keep the core Configuration class with:
   - Constructor: `Configuration(String name)`
   - Methods: `getName()`, `hasValue(Option<?> option)`, `getValue(Option<?> option)`, `setValue(Option<?> option, Object value)`
   - Internal storage: `Map<String, Object>` for option values

**Files to modify**:
- `turnus-headless/turnus-common/src/main/java/turnus/common/configuration/Configuration.java` (recreate)
- `turnus-headless/turnus-common/src/main/java/turnus/common/TurnusConstants.java` (remove LaunchConfigurationParser references)

**Estimated effort**: 1-2 hours (careful editing to remove Eclipse code without breaking core functionality)

---

### Option B: Remove Configuration Dependencies (Quick workaround, reduced functionality)

If Configuration is not critical for initial headless operation, remove it entirely:

**Files to modify**:

1. **TurnusConstants.java** (line 37)
   ```java
   // Remove this import
   - import turnus.common.configuration.Configuration.LaunchConfigurationParser;
   
   // Update Javadoc to remove references to LaunchConfigurationParser
   ```

2. **FileUtils.java**
   ```java
   // Remove Configuration import
   - import turnus.common.configuration.Configuration;
   
   // Remove or modify createOutputDirectory method:
   // Option 1: Delete the method entirely
   // Option 2: Change signature to accept File directly instead of Configuration
   public static File createOutputDirectory(String analysisName, File traceFile) {
       if (traceFile == null) {
           throw new TurnusException("The output directory cannot be created since no trace file is defined");
       }
       File dir = traceFile.getParentFile();
       dir = new File(dir, "analysis");
       dir = new File(dir, analysisName);
       if (!dir.exists()) {
           try {
               createDirectory(dir);
           } catch (Exception e) {
               throw new TurnusException("The output directory \"" + dir + "\" cannot be created", e);
           }
       }
       configuration.setValue(TurnusOptions.OUTPUT_DIRECTORY, dir);
       return dir;
   }
   ```

**Estimated effort**: 30 minutes (but may break analysis tools that depend on Configuration)

**Impact**: Analysis tools will need to be refactored to not use Configuration class

---

## Recommendation

**Use Option A** - Recreate Configuration class without Eclipse dependencies.

**Reasoning**:
- Configuration is a core utility used throughout the codebase
- It provides a clean way to pass analysis options
- The Eclipse dependency is only in the LaunchConfigurationParser inner class
- Core Configuration functionality is pure Java (just a Map wrapper)
- Removing it will require extensive refactoring of analysis modules

**Next Steps**:
1. Copy original Configuration.java to turnus-headless
2. Remove LaunchConfigurationParser inner class (self-contained, easy to delete)
3. Remove ILaunchConfiguration imports and related methods
4. Test compilation
5. If successful, proceed with building turnus-common and turnus-model

---

## Build Status

Current build attempt:
```
[ERROR] TurnusConstants.java:[37,49] package turnus.common.configuration.Configuration does not exist
[ERROR] FileUtils.java:[59,35] cannot find symbol
  symbol:   class Configuration
  location: package turnus.common.configuration
[ERROR] FileUtils.java:[285,71] cannot find symbol
  symbol:   class Configuration
  location: class turnus.common.util.FileUtils
```

After Configuration is fixed:
- turnus-common should compile successfully
- Can then proceed to build turnus-model
- Then turnus-bundle and turnus-analysis

---

## Eclipse API Reference Count

Remaining Eclipse **Platform** API references (not including EMF):
- **ILaunchConfiguration**: Used in deleted Configuration.java (was in LaunchConfigurationParser)
- **IFile/IFolder/IProject/IWorkspaceRoot**: All references removed or are just in Javadoc comments
- **ResourcesPlugin**: All removed

Javadoc-only references (not actual code, safe to keep or clean up later):
- FileUtils.java line 62: Comment mentions IFile in class description
- EcoreUtils.java line 160: Comment mentions IFile in method description

EMF APIs (kept, these are allowed):
- org.eclipse.emf.ecore.* - Keep all
- org.eclipse.emf.common.util.* - Keep all

---

## Updated Phase 2 Plan

**Current Status**: Phase 2 - Step 8 "Cleaning Eclipse dependencies from turnus-common utility classes"

**Remaining Work**:
1. ⏸️ Fix Configuration.java issue (this document addresses it)
2. ⏸️ Build turnus-common successfully
3. ⏸️ Build turnus-model successfully
4. ⏸️ Commit Phase 2 progress

**After Phase 2**:
- Phase 3: Migrate turnus-bundle
- Phase 4: Migrate turnus-analysis  
- Phase 5: Create turnus-cli
- Phase 6-7: Testing and distribution
