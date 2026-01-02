# turnus.bundle - Dependency Management

## Overview
This bundle uses a **hybrid approach** for dependency management:
- **P2/Orbit dependencies**: Common libraries from Eclipse Orbit (ASM, Commons, Guava)
- **Embedded JARs**: Specialized libraries not available in P2 (Weka, JGraphT, FlexMark, POI, etc.)

## Dependency Sources

### From P2/Orbit (declared in MANIFEST.MF Require-Bundle):
- ✅ org.objectweb.asm (ASM bytecode library) - 9.7.0 with tree, analysis, util modules
- ✅ com.google.guava - 33.0.0

### Embedded in lib/ (declared in pom.xml):
- Apache Commons (IO, Codec, Lang3, Logging, CLI, Compress, Math3)
- JGraphT (graph algorithms)
- Apache POI (Office document processing)
- Weka (machine learning)
- CommonMark (Markdown processing)
- FastUtil (high-performance collections)
- And ~20 other specialized libraries

## How to Add/Update Dependencies

### Adding a P2/Orbit Dependency:
1. Check availability at: https://download.eclipse.org/tools/orbit/simrel/orbit-aggregation/2024-09/
2. Add to `turnus.target/turnus.target.target`:
   ```xml
   <unit id="org.example.library" version="0.0.0"/>
   ```
3. Add to `META-INF/MANIFEST.MF`:
   ```
   Require-Bundle: ...,
    org.example.library;bundle-version="1.0.0";visibility:=reexport
   ```

### Adding an Embedded JAR Dependency:
1. Add to `pom.xml`:
   ```xml
   <dependency>
       <groupId>com.example</groupId>
       <artifactId>library</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```
2. Run the sync script:
   ```bash
   ./sync-dependencies.sh
   ```
3. Review and commit changes to `META-INF/MANIFEST.MF`

### Updating a Dependency Version:
1. **P2 dependency**: Update version in `MANIFEST.MF` (P2 will resolve automatically)
2. **Embedded JAR**: Update version in `pom.xml`, then run `./sync-dependencies.sh`

## Automation Script

**sync-dependencies.sh** - Auto-syncs Maven dependencies with MANIFEST.MF
- Copies JARs from Maven to `lib/`
- Updates `Bundle-ClassPath` in `MANIFEST.MF`
- Maintains proper formatting

Usage:
```bash
./sync-dependencies.sh
```

## Build Process

The Maven build:
1. Resolves P2 dependencies from Orbit repository
2. Downloads embedded dependencies to `lib/`
3. Packages everything into the OSGi bundle
4. Exports packages for use by other bundles

## Benefits of This Approach

✅ **Reduced bloat**: ASM and Guava from P2 instead of embedded  
✅ **Version consistency**: Orbit provides tested, compatible versions for core libraries  
✅ **Maven-managed**: Single source of truth in pom.xml  
✅ **Automatic sync**: Script maintains MANIFEST.MF  
✅ **Hybrid approach**: P2 for platform libraries, embedded for specialized ones  

## Migration History

- **Pre-modernization**: 311 embedded JARs, all manually managed
- **After modernization**: ASM + Guava from P2/Orbit (~7 bundles), ~25 libraries embedded, automated sync
