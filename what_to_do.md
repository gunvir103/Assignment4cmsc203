# Assignment 4 - What To Do Next

## Required Screenshots for Submission

### 1. GUI Screenshots (JavaFX Application)
Run `MgmCompanyGui.java` and take screenshots of:

- [ ] **Startup Screen** - Empty GUI when first launched
- [ ] **Add Management Company Info** - After entering company details (show the management plot outline)
- [ ] **Successful Property Addition** - After adding 2-3 properties successfully
- [ ] **Property Overlap Error** - When trying to add overlapping property 
- [ ] **Property Outside Management Plot Error** - Property extends beyond company boundaries
- [ ] **Array Full Error** - Trying to add 6th property (max is 5)
- [ ] **Max Rent Button Result** - Display highest rent property
- [ ] **Total Rent Button Result** - Display total rent calculation
- [ ] **List of Properties Button Result** - Display all properties with management fee

### 2. JUnit Test Screenshots
Take screenshots showing ALL tests passing:

- [ ] **PlotTestGFA** - All instructor tests passing
- [ ] **PlotTestStudent** - All your student tests passing  
- [ ] **PropertyTestGFA** - All instructor tests passing
- [ ] **PropertyTestStudent** - All your student tests passing
- [ ] **ManagementCompanyGFATest** - All instructor tests passing
- [ ] **ManagementCompanyTestStudent** - All your student tests passing

### 3. GitHub Repository Screenshot
- [ ] **src folder contents** - Show all Java files in your GitHub repository

## Required Documents to Create

### 4. UML Class Diagram
- [ ] Create UML diagram for Plot, Property, and ManagementCompany classes
- [ ] Include all attributes, methods, and relationships
- [ ] Show aggregation relationship between Property and Plot
- [ ] Show composition relationship between ManagementCompany and Property array

### 5. Test Plan Documentation
- [ ] Write test plan describing test cases for each method
- [ ] Document test data and expected results
- [ ] Explain edge cases tested

### 6. Lessons Learned Section
Answer these questions:
- [ ] What have you learned?
- [ ] What did you struggle with?
- [ ] What would you do differently on your next project?
- [ ] What parts were you successful with, and what parts (if any) were you not successful with?
- [ ] Additional resources/links/videos used

### 7. Pseudocode/Flowchart
- [ ] Create pseudocode for key methods (addProperty, overlaps, encompasses)
- [ ] Write in natural language like a second year CS student would

## File Deliverables

### FirstInitialLastName_Assignment4_Complete.zip
Should contain:
- [ ] src folder with: Plot.java, Property.java, ManagementCompany.java
- [ ] JUnit test files: PlotTestStudent.java, PropertyTestStudent.java, ManagementCompanyTestStudent.java  
- [ ] Word document with UML, screenshots, test plan, lessons learned, pseudocode

### FirstInitialLastName_Assignment4_JavaFiles.zip  
Should contain ONLY:
- [ ] Plot.java
- [ ] Property.java  
- [ ] ManagementCompany.java

## Testing Commands to Run

```bash
# Compile all classes
javac -cp "src:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" src/*.java

# Run GUI (need JavaFX module path)
java -cp "src:lib/javafx-sdk-21.0.2/lib/*" --module-path lib/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml MgmCompanyGui

# Run all tests
java -cp "src:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore PlotTestGFA PropertyTestGFA ManagementCompanyGFATest PlotTestStudent PropertyTestStudent ManagementCompanyTestStudent
```

## Notes
- Make sure all tests pass before taking screenshots
- GUI should demonstrate all the scenarios mentioned in the assignment description
- GitHub repository should be up to date with final code
- All documentation should be professional and well-formatted