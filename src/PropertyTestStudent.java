/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: Student test class for the Property class. Tests all public methods
 *              including constructors, getters, setters, and toString.
 * Due: MM/DD/YYYY
 * Platform/compiler: IntelliJ IDEA / Java
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Gunvir Lubana
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {
    
    private Property property1, property2, property3;

    @Before
    public void setUp() throws Exception {
        // Create test properties with randomized realistic data
        property1 = new Property("Sunset Manor Condos", "Rockville", 2847.25, "Jennifer Martinez");
        property2 = new Property("Oakwood Terrace", "Silver Spring", 3192.80, "David Kim", 5, 8, 4, 3);
        property3 = new Property();  // default one for testing
    }

    @After
    public void tearDown() throws Exception {
        property1 = property2 = property3 = null;
    }

    /**
     * Test the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        Property defaultProperty = new Property();
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0.0, defaultProperty.getRentAmount(), 0.01);
        
        // Check that default plot is created
        assertNotNull("Plot should not be null", defaultProperty.getPlot());
        assertEquals("Default plot x should be 0", 0, defaultProperty.getPlot().getX());
        assertEquals("Default plot y should be 0", 0, defaultProperty.getPlot().getY());
        assertEquals("Default plot width should be 1", 1, defaultProperty.getPlot().getWidth());
        assertEquals("Default plot depth should be 1", 1, defaultProperty.getPlot().getDepth());
    }
    
    /**
     * Test constructor with just the basic property info
     */
    @Test
    public void testConstructorWithPropertyInfo() {
        Property testProperty = new Property("Highland Towers", "Bethesda", 2769.50, "Alexander Rodriguez");
        assertEquals("Highland Towers", testProperty.getPropertyName());
        assertEquals("Bethesda", testProperty.getCity());
        assertEquals("Alexander Rodriguez", testProperty.getOwner());
        assertEquals(2769.50, testProperty.getRentAmount(), 0.01);
        
        // Should have default plot
        assertEquals("Default plot x should be 0", 0, testProperty.getPlot().getX());
        assertEquals("Default plot y should be 0", 0, testProperty.getPlot().getY());
        assertEquals("Default plot width should be 1", 1, testProperty.getPlot().getWidth());
        assertEquals("Default plot depth should be 1", 1, testProperty.getPlot().getDepth());
    }
    
    /**
     * Test the constructor with all information including plot
     */
    @Test
    public void testConstructorWithAllInfo() {
        Property testProperty = new Property("Willow Creek Estates", "Gaithersburg", 3421.75, "Maria Gonzalez", 12, 7, 6, 9);
        assertEquals("Willow Creek Estates", testProperty.getPropertyName());
        assertEquals("Gaithersburg", testProperty.getCity());
        assertEquals("Maria Gonzalez", testProperty.getOwner());
        assertEquals(3421.75, testProperty.getRentAmount(), 0.01);
        
        // Check custom plot
        assertEquals("Plot x should be 12", 12, testProperty.getPlot().getX());
        assertEquals("Plot y should be 7", 7, testProperty.getPlot().getY());
        assertEquals("Plot width should be 6", 6, testProperty.getPlot().getWidth());
        assertEquals("Plot depth should be 9", 9, testProperty.getPlot().getDepth());
    }
    
    /**
     * Test the copy constructor
     */
    @Test
    public void testCopyConstructor() {
        Property copyProperty = new Property(property2);
        
        // Check that all values are copied correctly
        assertEquals(property2.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(property2.getCity(), copyProperty.getCity());
        assertEquals(property2.getOwner(), copyProperty.getOwner());
        assertEquals(property2.getRentAmount(), copyProperty.getRentAmount(), 0.01);
        
        // Check that plot is deep copied
        assertEquals(property2.getPlot().getX(), copyProperty.getPlot().getX());
        assertEquals(property2.getPlot().getY(), copyProperty.getPlot().getY());
        assertEquals(property2.getPlot().getWidth(), copyProperty.getPlot().getWidth());
        assertEquals(property2.getPlot().getDepth(), copyProperty.getPlot().getDepth());
        
        // Check that it's a different object (not same reference)
        assertNotSame("Properties should be different objects", property2, copyProperty);
        assertNotSame("Plots should be different objects", property2.getPlot(), copyProperty.getPlot());
        
        // change original and make sure copy isn't affected
        property2.setPropertyName("Changed Name");
        property2.getPlot().setX(999);
        assertEquals("Oakwood Terrace", copyProperty.getPropertyName());  // copy should still have original value
        assertEquals(5, copyProperty.getPlot().getX());  // copy plot should still have original value
    }
    
    /**
     * Test getter methods
     */
    @Test
    public void testGetters() {
        assertEquals("Property name should match", "Sunset Manor Condos", property1.getPropertyName());
        assertEquals("City should match", "Rockville", property1.getCity());
        assertEquals("Owner should match", "Jennifer Martinez", property1.getOwner());
        assertEquals("Rent amount should match", 2847.25, property1.getRentAmount(), 0.01);
        
        // Test that getPlot returns a Plot object
        assertNotNull("Plot should not be null", property1.getPlot());
        
        // Test property with custom plot
        assertEquals("Oakwood Terrace", property2.getPropertyName());
        assertEquals("Silver Spring", property2.getCity());
        assertEquals("David Kim", property2.getOwner());
        assertEquals(3192.80, property2.getRentAmount(), 0.01);
        assertEquals(5, property2.getPlot().getX());
        assertEquals(8, property2.getPlot().getY());
        assertEquals(4, property2.getPlot().getWidth());
        assertEquals(3, property2.getPlot().getDepth());
    }
    
    /**
     * Test setter methods
     */
    @Test
    public void testSetters() {
        Property testProperty = new Property();
        
        testProperty.setPropertyName("New Property Name");
        assertEquals("Property name should be set", "New Property Name", testProperty.getPropertyName());
        
        testProperty.setCity("New City");
        assertEquals("City should be set", "New City", testProperty.getCity());
        
        testProperty.setOwner("New Owner");
        assertEquals("Owner should be set", "New Owner", testProperty.getOwner());
        
        testProperty.setRentAmount(1234.56);
        assertEquals("Rent amount should be set", 1234.56, testProperty.getRentAmount(), 0.01);
        
        // Test setting a new plot
        Plot newPlot = new Plot(10, 20, 30, 40);
        testProperty.setPlot(newPlot);
        assertEquals("Plot should be set", newPlot, testProperty.getPlot());
        assertEquals(10, testProperty.getPlot().getX());
        assertEquals(20, testProperty.getPlot().getY());
        assertEquals(30, testProperty.getPlot().getWidth());
        assertEquals(40, testProperty.getPlot().getDepth());
    }
    
    /**
     * Test toString method format
     */
    @Test
    public void testToString() {
        // test property1
        String expected1 = "Sunset Manor Condos,Rockville,Jennifer Martinez,2847.25";
        assertEquals("toString should match expected format", expected1, property1.toString());
        
        // test property2
        String expected2 = "Oakwood Terrace,Silver Spring,David Kim,3192.8";
        assertEquals("toString should match expected format", expected2, property2.toString());
        
        // Test default property
        String expected3 = ",,,0.0";
        assertEquals("Default property toString should match format", expected3, property3.toString());
        
        // Test property with decimal rent
        Property decimalProperty = new Property("Test", "City", 1234.56, "Owner");
        String expectedDecimal = "Test,City,Owner,1234.56";
        assertEquals("Property with decimal rent should format correctly", expectedDecimal, decimalProperty.toString());
    }
}