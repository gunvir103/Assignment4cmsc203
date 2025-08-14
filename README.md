# Assignment 4 CMSC203 - Property Management System

## ✅ Configuration Status

Both JUnit and JavaFX have been properly configured and are working correctly!

## 📁 Project Structure

```
Assignment4cmsc203/
├── lib/                          # External libraries
│   ├── junit-4.13.2.jar          # JUnit testing framework
│   ├── hamcrest-core-1.3.jar     # JUnit dependency
│   └── javafx-sdk-21.0.2/        # JavaFX SDK
│       └── lib/                   # JavaFX JAR files
├── src/                          # Source code
│   ├── Property.java             # Property class
│   ├── Plot.java                 # Plot class
│   ├── ManagementCompany.java    # Management company class
│   ├── MgmCompanyGui.java        # JavaFX GUI application
│   ├── PropertyTestStudent.java  # JUnit tests for Property
│   └── ManagementCompanyTestStudent.java # JUnit tests for ManagementCompany
├── run.sh                        # Build and test script
└── Assignment4cmsc203.iml        # IntelliJ module file (updated)
```

## 🧪 Running Tests

### Option 1: Use the provided script
```bash
./run.sh
```

### Option 2: Manual commands

**Compile all files:**
```bash
javac -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/javafx-sdk-21.0.2/lib/*:src" \
      --module-path lib/javafx-sdk-21.0.2/lib \
      --add-modules javafx.controls,javafx.fxml \
      src/*.java
```

**Run Property tests:**
```bash
java -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:src" \
     org.junit.runner.JUnitCore PropertyTestStudent
```

**Run ManagementCompany tests:**
```bash
java -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:src" \
     org.junit.runner.JUnitCore ManagementCompanyTestStudent
```

## 🖥️ Running the GUI Application

### From IntelliJ IDEA:

1. Open the project in IntelliJ IDEA
2. Go to `Run > Edit Configurations...`
3. Select or create a configuration for `MgmCompanyGui`
4. In `VM Options`, add:
   ```
   --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml
   ```
5. Run the configuration

### From Command Line (may have display issues):
```bash
java -cp "lib/javafx-sdk-21.0.2/lib/*:src" \
     --module-path lib/javafx-sdk-21.0.2/lib \
     --add-modules javafx.controls,javafx.fxml \
     MgmCompanyGui
```

## 📝 Test Results Summary

- ✅ **PropertyTestStudent**: 7 tests passed
- ✅ **ManagementCompanyTestStudent**: 21 tests passed
- ✅ **JavaFX GUI**: Compiles successfully (GUI requires proper display environment)

## 🔧 Configuration Details

### JUnit Configuration:
- **Version**: 4.13.2
- **Dependencies**: hamcrest-core-1.3.jar
- **Location**: `lib/` directory
- **Module File**: Updated to reference local JARs

### JavaFX Configuration:
- **Version**: 21.0.2
- **Platform**: macOS x64
- **Location**: `lib/javafx-sdk-21.0.2/`
- **Required Modules**: javafx.controls, javafx.fxml
- **Module File**: Updated with all JavaFX JAR references

## 🚨 Issues Resolved

1. **JUnit not configured**: ✅ Fixed
   - Downloaded JUnit 4.13.2 and hamcrest-core-1.3.jar
   - Updated module file with correct paths
   - All tests now run successfully

2. **JavaFX not configured**: ✅ Fixed  
   - Downloaded JavaFX SDK 21.0.2 for macOS
   - Updated module file with JavaFX libraries
   - Code compiles without errors
   - GUI can run in IntelliJ with proper VM options

## 🎯 Quick Start

1. Open project in IntelliJ IDEA
2. Run `./run.sh` to verify everything works
3. Use the VM options provided above when running the GUI
4. All JUnit tests should pass automatically

The project is now fully configured and ready for development and testing!
