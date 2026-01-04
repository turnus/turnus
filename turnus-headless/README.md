# Turnus Headless

Pure Maven headless version of the Turnus dataflow analysis toolkit - no Eclipse/OSGi dependencies.

## Overview

Turnus Headless is a clean-room implementation of the Turnus analysis toolkit that can be built and run without Eclipse. It uses:
- **EMF (Eclipse Modeling Framework)** for data models - standalone EMF, no Eclipse runtime
- **ADEVS** for discrete event simulation - the heart of Turnus
- **picocli** for command-line interface
- **Pure Maven** for build system

## Module Architecture

```
turnus-common-api  (base interfaces)
       ↓
turnus-model       (EMF data models)
       ↓
turnus-common      (utilities, I/O)
       ↓
turnus-adevs       (simulation engine)
       ↓
turnus-analysis    (analysis algorithms)
       ↓
turnus-cli         (command-line interface)
```

## Modules

| Module | Description | Source Files |
|--------|-------------|--------------|
| turnus-common-api | Base interfaces and exceptions | 2 |
| turnus-common | Common utilities, configuration, I/O | 34 |
| turnus-model | EMF models for dataflow, trace, analysis | 464 |
| turnus-adevs | ADEVS simulation engine - the heart of Turnus | 40 |
| turnus-analysis | Analysis algorithms (impact, buffer, partitioning, simulation) | 127 |
| turnus-cli | Command-line interface with picocli | 5 |

**Total: 672 Java source files**

## Building

### Requirements
- Java 17 or higher (tested with Microsoft OpenJDK 21)
- Maven 3.9+

### Build Commands

```bash
# Set JAVA_HOME (if needed)
export JAVA_HOME=~/.jdk/jdk-21.0.8

# Build all modules
mvn clean install -DskipTests

# Build executable CLI JAR
mvn clean package -DskipTests
```

The executable JAR is created at: `turnus-cli/target/turnus-cli-1.0.0-SNAPSHOT.jar` (55MB, includes all dependencies)

## Usage

### Command Line Interface

```bash
# Show help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar --help

# Available commands
java -jar turnus-cli-1.0.0-SNAPSHOT.jar help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar impact --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar critical-path --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar scheduled-critical-path --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar buffer --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar ipcomm --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar iacomm --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar latency --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar max-buffer --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar optimal-buffer-topdown --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar optimal-buffer-critical-blocking --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar optimal-buffer-heavy-blocking --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar varpipe --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar pimpact --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar amtrace --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar ctrace --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar dtraces --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar partition --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar simulate --help
```

### Analysis Commands

#### Impact Analysis
```bash
java -jar turnus-cli-1.0.0-SNAPSHOT.jar impact <trace.tracez> \
    --max-points 10 \
    --class-level \
    -o output/
```

#### Critical Path Analysis
```bash
java -jar turnus-cli-1.0.0-SNAPSHOT.jar critical-path <trace.tracez> \
    -w weights.exdf \
    -o output/
```

#### Buffer Analysis
```bash
java -jar turnus-cli-1.0.0-SNAPSHOT.jar buffer <trace.tracez> \
    --bit-accurate \
    --pow2 \
    -o output/
```

#### Partitioning Analysis
```bash
java -jar turnus-cli-1.0.0-SNAPSHOT.jar partition <trace.tracez> \
    -u 4 \
    -o output/
```

## API Usage

```java
import turnus.model.ModelsRegister;
import turnus.model.trace.TraceProject;
import turnus.analysis.bottlenecks.AlgorithmicImpactAnalysis;
import turnus.model.analysis.bottlenecks.ImpactAnalysisReport;

// Initialize EMF models
ModelsRegister.init();

// Open trace project
TraceProject project = TraceProject.open(new File("trace.tracez"));

// Run analysis
AlgorithmicImpactAnalysis analysis = new AlgorithmicImpactAnalysis(project);
ImpactAnalysisReport report = analysis.run();
```

## Dependencies

Key dependencies (all managed via Maven):
- EMF 2.39+ (standalone, no Eclipse runtime)
- picocli 4.7.5 (CLI framework)
- JGraphT 1.5.2 (graph algorithms)
- FastUtil 8.5.13 (high-performance collections)
- Apache POI 5.3.0 (Excel export)
- Apache Commons (IO, Math, CLI)
- CommonMark 0.21.0 (Markdown processing)
- JGit 6.10.0 (Git versioning)
- javax.json 1.1.4 (JSON processing)

## What's Different from Eclipse Version

| Feature | Eclipse Turnus | Turnus Headless |
|---------|----------------|-----------------|
| Build system | Eclipse Tycho | Pure Maven |
| CLI framework | Eclipse IApplication | picocli |
| Extension registry | Eclipse extension points | Direct factory registration |
| UI | Eclipse RCP | None (headless) |
| ADEVS simulation | ✓ | ✓ |
| Trace loading | Extension point based | TraceLoaderFactory |
| Versioning | Extension point based | VersioningFactoryImpl |

## License

GNU General Public License v3.0 with Eclipse Public License exception.
