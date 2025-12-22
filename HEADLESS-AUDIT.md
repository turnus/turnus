# Turnus Headless Version - Audit & Refactoring Plan

## Executive Summary

**Current State**: Turnus is an Eclipse RCP application with both CLI and UI components, heavily dependent on EMF (Eclipse Modeling Framework) for data models.

**Goal**: Create a pure headless/CLI version with all Eclipse UI dependencies removed.

**Challenge**: EMF is deeply embedded in the data layer. Removing it requires **massive refactoring** of the model layer.

---

## Module Analysis

### 1. ✅ **Can Remain (Headless-Ready)**

#### turnus.bundle
- **Purpose**: Library aggregator
- **Status**: ✅ No UI dependencies
- **EMF**: ❌ None
- **Action**: Keep as-is

#### turnus.common  
- **Purpose**: Configuration, utilities, I/O
- **Status**: ✅ Already headless-ready
- **EMF**: ❌ None
- **Dependencies**: Apache Commons CLI for command-line parsing
- **Action**: Keep as-is

#### turnus.analysis (Partially)
- **Purpose**: Analysis algorithms + CLI tools
- **Status**: ⚠️ Mixed (algorithms are headless, but depends on EMF models)
- **EMF**: ✅ Heavy (through turnus.model dependency)
- **Existing CLI tools**:
  - `TimelineCli` - Timeline simulation
  - `AlgorithmicPartialCriticalPathAnalysisCli` - Critical path analysis
  - `BoundedBufferAnalysisCli` - Buffer analysis
  - `InterPartitionCommunicationAndMemoryAnalysisCli` - Communication analysis
  - `DynamicRRPartitioningCli` - Dynamic partitioning
  - `LinearCommunicationWeightCli` - Communication weight
- **Action**: Core algorithms can stay, but needs new non-EMF data layer

---

### 2. ❌ **Must Remove (UI Components)**

#### turnus.ui
- **Purpose**: Eclipse UI components (wizards, views, preferences)
- **Status**: ❌ Pure UI bundle
- **Dependencies**: 
  - `org.eclipse.ui`
  - `org.eclipse.ui.ide`
  - `org.eclipse.ui.console`
  - `org.eclipse.swt`
  - `org.eclipse.jface`
- **Action**: **REMOVE COMPLETELY**

#### turnus.analysis.ui
- **Purpose**: Analysis UI handlers and wizards
- **Status**: ❌ Pure UI bundle
- **Dependencies**:
  - `org.eclipse.ui.handlers`
  - `org.eclipse.jface.wizard`
  - `org.eclipse.swt.widgets`
- **Action**: **REMOVE COMPLETELY**

#### turnus.adevs (Partially)
- **Purpose**: DEVS simulation framework
- **Status**: ⚠️ Has UI dependency
- **Dependencies**: `org.eclipse.ui` (Require-Bundle)
- **Action**: Remove UI dependency or split into core + UI

#### turnus.feature
- **Purpose**: Eclipse feature packaging
- **Status**: ❌ Only for Eclipse RCP
- **Action**: **REMOVE** (not needed for CLI distribution)

---

### 3. 🔴 **CRITICAL: turnus.model - The EMF Problem**

#### Current State
- **5 Ecore models**:
  1. `analysis.ecore` - Analysis results data structures
  2. `dataflow.ecore` - Dataflow network models
  3. `architecture.ecore` - Architecture models
  4. `common.ecore` - Common types
  5. `versioning.ecore` - Versioning metadata

- **Generated Code**: ~200+ Java classes auto-generated from Ecore
- **EMF Dependencies**:
  ```xml
  org.eclipse.emf.ecore - Core EMF framework
  org.eclipse.emf.ecore.xmi - XML serialization
  org.eclipse.emf.common - Common utilities
  ```

#### Impact Analysis

**Classes extending EMF**:
```java
public interface ActionVariablePipeliningData extends EObject
public class AccessDataImpl extends MinimalEObjectImpl
// ~200+ similar classes
```

**Used Throughout**:
- turnus.analysis depends on EMF models for ALL data structures
- CLI tools serialize/deserialize using EMF XMI format
- All analysis results stored as EMF models

---

## EMF Removal Feasibility Assessment

### Option 1: ❌ Keep EMF (Minimal Effort)
**Pros**: 
- No refactoring needed
- EMF can run headless (org.eclipse.emf.ecore is not UI-dependent)

**Cons**:
- Still pulls in Eclipse dependencies
- Large dependency footprint
- Not truly independent from Eclipse ecosystem

**Verdict**: Defeats the purpose of "pure headless"

---

### Option 2: ✅ Replace EMF with POJOs + Jackson/JAXB (Recommended)

**Strategy**: Rewrite all EMF models as Plain Old Java Objects (POJOs)

#### What Needs Rewriting:

1. **Data Structures** (~200 classes)
   - Replace `EObject` interfaces with regular Java interfaces
   - Replace `MinimalEObjectImpl` with plain classes
   - Add proper getters/setters
   - Remove EMF-specific code (`eStaticClass()`, `eGet()`, etc.)

2. **Serialization**
   - Replace EMF XMI with:
     - **JSON** (Jackson) - Modern, lightweight
     - **XML** (JAXB) - If XML compatibility needed
     - **Binary** (Protobuf) - For performance

3. **Factory Pattern**
   - Replace EMF Factories with builder pattern or simple factories

4. **Containment/References**
   - Replace EMF containment with standard composition
   - Replace EMF cross-references with ID-based references

#### Example Refactoring:

**Before (EMF)**:
```java
public interface AnalysisReport extends EObject {
    String getAlgorithm();
    void setAlgorithm(String value);
    Date getDate();
    void setDate(Date value);
}

public class DynamicProfilingReportImpl extends MinimalEObjectImpl 
    implements DynamicProfilingReport {
    protected EClass eStaticClass() {
        return ProfilerPackage.Literals.DYNAMIC_PROFILING_REPORT;
    }
    // EMF machinery...
}
```

**After (POJO + Jackson)**:
```java
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DynamicProfilingReport.class, name = "dynamicProfiling"),
    // other subtypes...
})
public interface AnalysisReport {
    String getAlgorithm();
    void setAlgorithm(String algorithm);
    Date getDate();
    void setDate(Date date);
}

@JsonTypeName("dynamicProfiling")
public class DynamicProfilingReport implements AnalysisReport {
    private String algorithm;
    private Date date;
    private Network network;
    private List<ActorDynamicData> actorsData;
    
    // Standard getters/setters
    public String getAlgorithm() { return algorithm; }
    public void setAlgorithm(String algorithm) { this.algorithm = algorithm; }
    // etc...
}
```

---

### Option 3: ⚠️ Use Alternative Modeling Framework

**Alternatives**:
- **Apache Commons Lang** - Builder utilities
- **Lombok** - Reduce boilerplate
- **Immutables** - Immutable data classes
- **AutoValue** - Value classes

**Verdict**: Still requires rewriting all models, but with less boilerplate

---

## Effort Estimation

### Phase 1: Remove UI Dependencies (2-3 days)
- ✅ Delete turnus.ui module
- ✅ Delete turnus.analysis.ui module
- ✅ Clean turnus.adevs of UI dependencies
- ✅ Remove turnus.feature
- ✅ Update pom.xml reactor

### Phase 2: EMF Model Refactoring (3-4 weeks) 🔴 **HUGE**

#### Week 1: Common & Dataflow Models
- Rewrite `common.ecore` → POJOs
- Rewrite `dataflow.ecore` → POJOs
- Add Jackson annotations
- Create JSON serializers/deserializers
- Unit tests for serialization

#### Week 2: Analysis Models
- Rewrite `analysis.ecore` → POJOs
- Migrate all analysis result classes
- Migrate profiler data structures
- Migrate bottleneck data structures

#### Week 3: Architecture & Versioning
- Rewrite `architecture.ecore` → POJOs
- Rewrite `versioning.ecore` → POJOs
- Update all factory classes

#### Week 4: Integration & Testing
- Update turnus.analysis to use new models
- Update all CLI tools
- Update I/O layer for new serialization
- Integration testing
- Performance testing

### Phase 3: Dependency Cleanup (1 day)
- Remove EMF dependencies from pom.xml
- Remove Eclipse Core Runtime if possible
- Update target platform
- Clean MANIFEST.MF files

### Phase 4: CLI Distribution (2-3 days)
- Create uber-JARs with all dependencies
- Update Maven Shade plugin configurations
- Create shell scripts for CLI tools
- Test standalone execution

---

## Recommended Approach

### Incremental Migration Strategy

**Stage 1: Parallel Implementation** (Safer)
1. Create `turnus.model.pojo` module alongside `turnus.model`
2. Implement POJO equivalents incrementally
3. Add adapters to convert EMF ↔ POJO
4. Migrate CLI tools one by one
5. Once stable, remove EMF module

**Stage 2: Big Bang** (Faster, riskier)
1. Branch from main
2. Delete all EMF-generated code
3. Rewrite from Ecore definitions
4. Fix all compilation errors
5. Extensive testing before merge

**Recommendation**: Use **Stage 1** for production systems

---

## Module Structure After Refactoring

```
turnus/
├── pom.xml                      # Parent POM
├── turnus.bundle/               # ✅ Keep - Library aggregator
├── turnus.common/               # ✅ Keep - Configuration & utilities
├── turnus.model.core/           # 🆕 New - POJO data models
│   ├── dataflow/               # Dataflow models
│   ├── analysis/               # Analysis models
│   ├── architecture/           # Architecture models
│   └── serialization/          # JSON/XML serializers
├── turnus.analysis/            # ✅ Keep - Analysis algorithms + CLI
├── turnus.adevs/               # ✅ Keep - DEVS simulation (headless)
└── turnus.cli/                 # 🆕 New - Unified CLI interface
```

---

## Technology Stack (After Refactoring)

### Core Dependencies
- **Java 21** ✅ Already upgraded
- **Maven 3.9+** ✅ Already in use
- **Apache Commons CLI** ✅ Already in use

### New Dependencies
- **Jackson 2.15+** - JSON serialization
- **SLF4J + Logback** - Logging
- **JUnit 5** - Testing
- **AssertJ** - Fluent assertions

### Removed Dependencies
- ❌ EMF (ecore, ecore.xmi, common)
- ❌ Eclipse Core Runtime
- ❌ Eclipse UI/SWT/JFace
- ❌ Eclipse Tycho (move to standard Maven)
- ❌ P2/Orbit

---

## Breaking Changes

### File Format Changes
- **Old**: `.xmi` files (EMF XMI format)
- **New**: `.json` or `.xml` files (Jackson serialization)
- **Migration Tool**: Need converter for existing files

### API Changes
```java
// OLD (EMF)
Network network = DataflowFactory.eINSTANCE.createNetwork();
network.setName("MyNetwork");

// NEW (POJO)
Network network = new Network();
network.setName("MyNetwork");
// Or with builder:
Network network = Network.builder()
    .name("MyNetwork")
    .build();
```

---

## Risk Assessment

### High Risk 🔴
- **EMF Removal**: Massive refactoring, high chance of introducing bugs
- **Data Migration**: All existing .xmi files need conversion
- **Testing Coverage**: Need comprehensive test suite before refactoring

### Medium Risk 🟡
- **Performance**: POJOs + Jackson might be slower than EMF for large models
- **Feature Parity**: Ensure all EMF features (lazy loading, proxies) have equivalents
- **Third-party Integration**: If external tools read .xmi files

### Low Risk 🟢
- **UI Removal**: Straightforward deletion
- **Dependency Updates**: Well-understood process

---

## Decision Matrix

| Approach | Effort | Risk | Timeline | Independence |
|----------|--------|------|----------|--------------|
| Keep EMF | Low | Low | 1 week | ⭐⭐ |
| Replace with POJOs | Very High | High | 1 month | ⭐⭐⭐⭐⭐ |
| Minimal EMF (headless) | Low | Low | 1 week | ⭐⭐⭐ |

---

## Recommendations

### For Production System:
**Use Minimal EMF Approach** ✅
- Keep EMF but run headless (EMF core doesn't need UI)
- Remove UI modules
- Keep CLI tools
- Fast, low-risk
- **Timeline**: 1-2 weeks

### For Long-term Independence:
**Replace EMF with POJOs** ⚠️
- Full refactoring to POJOs + Jackson
- Completely independent from Eclipse
- Modern, maintainable codebase
- **Timeline**: 4-6 weeks
- **Requires**: Dedicated team, extensive testing

---

## Next Steps

1. **Decision**: Choose approach (Minimal EMF vs. Full Refactoring)
2. **Pilot**: Start with one model (e.g., `common.ecore`) as proof-of-concept
3. **Test Suite**: Build comprehensive tests for current functionality
4. **Migration Plan**: Create detailed step-by-step plan
5. **Branch Strategy**: Create feature branch for refactoring
6. **Review Points**: Weekly reviews to assess progress

---

## Questions to Answer

1. **Do you have existing .xmi files that must remain compatible?**
   - If yes → Need migration tool
   - If no → Can change format freely

2. **Are external tools reading your data files?**
   - If yes → Must maintain format or provide converter
   - If no → Free to change

3. **What's your priority?**
   - Speed → Minimal EMF approach
   - Independence → Full POJO refactoring

4. **What's your risk tolerance?**
   - Low → Keep EMF, remove UI only
   - High → Full refactoring

5. **Do you have resources for 4-6 weeks of refactoring?**
   - Yes → Can do full refactoring
   - No → Stick with minimal EMF

---

**Conclusion**: Removing EMF is technically feasible but requires **massive effort** (1 month+ of dedicated work). For a headless CLI-only version, you can keep EMF's non-UI components and achieve 90% of the goal with 10% of the effort.
