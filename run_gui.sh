#!/bin/bash

# Script to run the JavaFX GUI
echo "=== Running Property Management GUI ==="
echo ""

# Compile all files including GUI
echo "Compiling all Java files..."
javac -cp "src:lib/javafx-sdk-21.0.2/lib/*" --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml src/*.java

echo ""
echo "Starting GUI..."
echo "Remember to take screenshots of:"
echo "1. Startup screen"
echo "2. After adding management company"
echo "3. After adding 2-3 properties successfully"
echo "4. Property overlap error"
echo "5. Property outside management plot error"
echo "6. Array full error (after 5 properties)"
echo "7. Max Rent button result"
echo "8. Total Rent button result"
echo "9. List of Properties button result"
echo ""

cd src
java -cp ".:../lib/javafx-sdk-21.0.2/lib/*" --module-path ../lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml MgmCompanyGui