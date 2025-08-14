#!/bin/bash

# Script to run the JavaFX GUI with proper module configuration
echo "=== Running Property Management GUI ==="
echo ""

# First compile everything
echo "Compiling all Java files..."
javac -cp "src:lib/javafx-sdk-21.0.2/lib/*" src/*.java

echo ""
echo "Starting GUI..."
echo ""

# Run with proper module-path and add-modules
cd src
java --module-path ../lib/javafx-sdk-21.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp ".:../lib/javafx-sdk-21.0.2/lib/*" \
     MgmCompanyGui