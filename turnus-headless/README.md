# Turnus Headless

Pure Maven headless version of the Turnus dataflow analysis toolkit - no Eclipse/OSGi dependencies.

## Overview

Turnus Headless is a clean-room implementation of the Turnus analysis toolkit that can be built and run without Eclipse. It uses:
- **EMF (Eclipse Modeling Framework)** for data models - standalone EMF, no Eclipse runtime
- **picocli** for command-line interface
- **Pure Maven** for build system

## Modules

| Module | Description | Source Files |
|--------|-------------|--------------|
| turnus-common-api | Base interfaces and exceptions | 2 |
| turnus-common | Common utilities, configuration, I/O | 34 |
| turnus-model | EMF models for dataflow, trace, analysis | 464 |
| turnus-adevs | ADEVS simulation engine - the heart of Turnus | 40 |
| turnus-analysis | Analysis algorithms (impact, buffer, partitioning, simulation) | 127 |
| turnus-cli | Command-line interface | 5 |

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
java -jar turnus-cli-1.0.0-SNAPSHOT.jar buffer --help
java -jar turnus-cli-1.0.0-SNAPSHOT.jar partition --help
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

Key dependencies:
- EMF 2.39+ (standalone)
- picocli 4.7.5 (CLI framework)
- JGraphT 1.5.2 (graph algorithms)
- Apache POI 5.3.0 (Excel export)
- Apache Commons (IO, Math, CLI)
- FlexMark 0.64.8 (Markdown processing)
- JGit 6.10.0 (Git versioning)

## What's Not Included

The following components from the original Turnus are not yet included:
- **turnus.adevs** - Simulation library (requires native ADEVS library)
- **Eclipse UI components** - IDE integration
- **Eclipse-based CLI classes** - Replaced with picocli commands

## License

GNU General Public License v3.0 with Eclipse Public License exception.
