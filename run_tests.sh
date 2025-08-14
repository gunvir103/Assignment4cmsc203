#!/bin/bash

# Script to run all JUnit tests for screenshots
echo "=== Running All JUnit Tests for Assignment 4 ==="
echo ""

# Set classpath
CP="src:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar"

# Compile all Java files
echo "Compiling all Java files..."
javac -cp "$CP" src/*.java

echo ""
echo "=== Running GFA (Instructor) Tests ==="
echo ""

echo "1. PlotTestGFA:"
java -cp "$CP" org.junit.runner.JUnitCore PlotTestGFA
echo ""

echo "2. PropertyTestGFA:"
java -cp "$CP" org.junit.runner.JUnitCore PropertyTestGFA
echo ""

echo "3. ManagementCompanyGFATest:"
java -cp "$CP" org.junit.runner.JUnitCore ManagementCompanyGFATest
echo ""

echo "=== Running Student Tests ==="
echo ""

echo "4. PlotTestStudent:"
java -cp "$CP" org.junit.runner.JUnitCore PlotTestStudent
echo ""

echo "5. PropertyTestStudent:"
java -cp "$CP" org.junit.runner.JUnitCore PropertyTestStudent
echo ""

echo "6. ManagementCompanyTestStudent:"
java -cp "$CP" org.junit.runner.JUnitCore ManagementCompanyTestStudent
echo ""

echo "=== All Tests Complete ==="