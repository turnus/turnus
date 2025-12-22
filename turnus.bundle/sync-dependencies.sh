#!/bin/bash
# Auto-generate MANIFEST.MF Bundle-ClassPath from pom.xml and lib/ directory
# Run this after adding/removing dependencies in pom.xml

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

echo "🔄 Syncing dependencies from Maven to MANIFEST.MF..."

# First, ensure dependencies are copied to lib/
echo "📦 Copying dependencies from Maven..."
mvn dependency:copy-dependencies -DoutputDirectory=lib -DoverWriteReleases=false -DoverWriteSnapshots=false -DoverWriteIfNewer=true -q

# Generate Bundle-ClassPath entries
echo "📝 Generating Bundle-ClassPath entries..."
CLASSPATH_ENTRIES=$(find lib -name "*.jar" -type f | sort | sed 's|^| |' | sed 's|$|,|' | tr '\n' '\n')

# Create temporary MANIFEST.MF with updated Bundle-ClassPath
echo "✏️  Updating MANIFEST.MF..."

# Read the current MANIFEST.MF and update Bundle-ClassPath section
python3 - <<'PYTHON_SCRIPT'
import re
import sys

manifest_path = "META-INF/MANIFEST.MF"

with open(manifest_path, 'r') as f:
    content = f.read()

# Find the Bundle-ClassPath section and Export-Package start
bundle_classpath_start = content.find('Bundle-ClassPath:')
export_package_start = content.find('Export-Package:')

if bundle_classpath_start == -1:
    print("❌ Bundle-ClassPath not found in MANIFEST.MF", file=sys.stderr)
    sys.exit(1)

# Generate new Bundle-ClassPath
import os
jars = sorted([f"lib/{f}" for f in os.listdir('lib') if f.endswith('.jar')])
classpath = "Bundle-ClassPath: .,\n " + ",\n ".join(jars)

# Keep everything before Bundle-ClassPath
before_classpath = content[:bundle_classpath_start]

# Keep everything from Export-Package onwards
after_classpath = content[export_package_start:]

# Combine
new_content = before_classpath + classpath + "\n" + after_classpath

with open(manifest_path, 'w') as f:
    f.write(new_content)

print(f"✅ Updated Bundle-ClassPath with {len(jars)} JARs")
PYTHON_SCRIPT

if [ $? -eq 0 ]; then
    echo "✅ MANIFEST.MF synchronized successfully!"
    echo ""
    echo "📋 Summary:"
    echo "   - Maven dependencies: $(ls -1 lib/*.jar 2>/dev/null | wc -l) JARs"
    echo "   - Updated MANIFEST.MF Bundle-ClassPath"
    echo ""
    echo "💡 Next steps:"
    echo "   1. Review META-INF/MANIFEST.MF changes"
    echo "   2. Run: mvn clean install"
    echo "   3. Commit changes if build succeeds"
else
    echo "❌ Failed to update MANIFEST.MF"
    exit 1
fi
