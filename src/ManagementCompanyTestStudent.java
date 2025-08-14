/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: Student test class for the ManagementCompany class. Tests all public methods
 *              including constructors, property management, rent calculations, and validation.
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

public class ManagementCompanyTestStudent {
    
    private ManagementCompany company1, company2;
    private Property prop1, prop2, prop3, prop4, prop5, prop6;

    @Before
    public void setUp() throws Exception {
        // create test management companies with randomized data
        company1 = new ManagementCompany("Eagle Ridge Property Management", "742859630", 8.75);
        company2 = new ManagementCompany("Horizon Real Estate Solutions", "381649572", 6.25, 0, 0, 10, 10);
        
        // create test properties with varied locations and realistic rents
        prop1 = new Property("Willowbrook Gardens", "Rockville", 2847.25, "Elena Rodriguez", 2, 1, 3, 2);
        prop2 = new Property("Harbor View Towers", "Columbia", 3254.80, "Brandon Mitchell", 6, 3, 2, 4);
        prop3 = new Property("Autumn Ridge Condos", "Frederick", 2195.50, "Priya Patel", 1, 6, 2, 3);
        prop4 = new Property("Crystal Lake Estates", "Annapolis", 3742.00, "Thomas Chen", 4, 7, 3, 2);
        prop5 = new Property("Sunridge Apartments", "Germantown", 2463.75, "Isabella Johnson", 8, 2, 2, 3);
        
        // property that would cause overlap with prop1
        prop6 = new Property("Conflicting Complex", "Rockville", 2100.00, "Overlap Owner", 2, 1, 5, 3);
    }

    @After
    public void tearDown() throws Exception {
        company1 = company2 = null;
        prop1 = prop2 = prop3 = prop4 = prop5 = prop6 = null;
    }

    /**
     * Test the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        ManagementCompany defaultCompany = new ManagementCompany();
        assertEquals("", defaultCompany.getName());
        assertEquals("", defaultCompany.getTaxID());
        assertEquals(0.0, defaultCompany.getMgmFeePer(), 0.01);
        assertEquals(0, defaultCompany.getPropertiesCount());
        assertFalse(defaultCompany.isPropertiesFull());
        
        // Check default plot
        assertEquals(0, defaultCompany.getPlot().getX());
        assertEquals(0, defaultCompany.getPlot().getY());
        assertEquals(ManagementCompany.MGMT_WIDTH, defaultCompany.getPlot().getWidth());
        assertEquals(ManagementCompany.MGMT_DEPTH, defaultCompany.getPlot().getDepth());
    }
    
    /**
     * Test constructor with company info and default plot
     */
    @Test
    public void testConstructorWithCompanyInfo() {
        assertEquals("Eagle Ridge Property Management", company1.getName());
        assertEquals("742859630", company1.getTaxID());
        assertEquals(8.75, company1.getMgmFeePer(), 0.01);
        assertEquals(0, company1.getPropertiesCount());
        
        // Should have default plot dimensions
        assertEquals(0, company1.getPlot().getX());
        assertEquals(0, company1.getPlot().getY());
        assertEquals(10, company1.getPlot().getWidth());
        assertEquals(10, company1.getPlot().getDepth());
    }
    
    /**
     * Test constructor with custom plot
     */
    @Test
    public void testConstructorWithCustomPlot() {
        ManagementCompany customCompany = new ManagementCompany("Custom Co", "111111111", 5.0, 2, 3, 15, 20);
        assertEquals("Custom Co", customCompany.getName());
        assertEquals("111111111", customCompany.getTaxID());
        assertEquals(5.0, customCompany.getMgmFeePer(), 0.01);
        
        // Check custom plot
        assertEquals(2, customCompany.getPlot().getX());
        assertEquals(3, customCompany.getPlot().getY());
        assertEquals(15, customCompany.getPlot().getWidth());
        assertEquals(20, customCompany.getPlot().getDepth());
    }
    
    /**
     * Test copy constructor
     */
    @Test
    public void testCopyConstructor() {
        // Add a property to company1 first
        company1.addProperty(prop1);
        
        ManagementCompany copyCompany = new ManagementCompany(company1);
        
        // Check that all values are copied
        assertEquals(company1.getName(), copyCompany.getName());
        assertEquals(company1.getTaxID(), copyCompany.getTaxID());
        assertEquals(company1.getMgmFeePer(), copyCompany.getMgmFeePer(), 0.01);
        assertEquals(company1.getPropertiesCount(), copyCompany.getPropertiesCount());
        
        // Check that plots are deep copied
        assertEquals(company1.getPlot().getX(), copyCompany.getPlot().getX());
        assertEquals(company1.getPlot().getY(), copyCompany.getPlot().getY());
        assertNotSame("Plots should be different objects", company1.getPlot(), copyCompany.getPlot());
        
        // Check that properties are deep copied
        assertNotSame("Property arrays should be different", company1.getProperties(), copyCompany.getProperties());
        
        // modify original and ensure copy is not affected
        company1.setName("Changed Name");
        assertEquals("Eagle Ridge Property Management", copyCompany.getName());
    }
    
    /**
     * Test addProperty with Property object - successful addition
     */
    @Test
    public void testAddPropertySuccess() {
        assertEquals(0, company1.addProperty(prop1));  // Should be added at index 0
        assertEquals(1, company1.getPropertiesCount());
        
        assertEquals(1, company1.addProperty(prop2));  // Should be added at index 1
        assertEquals(2, company1.getPropertiesCount());
        
        assertEquals(2, company1.addProperty(prop3));  // Should be added at index 2
        assertEquals(3, company1.getPropertiesCount());
    }
    
    /**
     * Test addProperty - array full condition
     */
    @Test
    public void testAddPropertyArrayFull() {
        // Add 5 properties (max)
        company1.addProperty(prop1);
        company1.addProperty(prop2);
        company1.addProperty(prop3);
        company1.addProperty(prop4);
        company1.addProperty(prop5);
        
        assertTrue("Company should be full", company1.isPropertiesFull());
        assertEquals(5, company1.getPropertiesCount());
        
        // Try to add 6th property
        Property prop6th = new Property("Sixth Property", "City", 1000.0, "Owner", 8, 8, 1, 1);
        assertEquals(-1, company1.addProperty(prop6th));  // Should return -1 for array full
        assertEquals(5, company1.getPropertiesCount());  // Count should not change
    }
    
    /**
     * Test addProperty - null property condition
     */
    @Test
    public void testAddPropertyNull() {
        assertEquals(-2, company1.addProperty(null));  // Should return -2 for null property
        assertEquals(0, company1.getPropertiesCount());  // Count should not change
    }
    
    /**
     * Test addProperty - property not encompassed condition
     */
    @Test
    public void testAddPropertyNotEncompassed() {
        // Create property outside management company plot (0,0,10,10)
        Property outsideProperty = new Property("Outside", "City", 1000.0, "Owner", 15, 15, 2, 2);
        assertEquals(-3, company1.addProperty(outsideProperty));  // Should return -3 for not encompassed
        assertEquals(0, company1.getPropertiesCount());  // Count should not change
    }
    
    /**
     * Test addProperty - overlapping properties condition
     */
    @Test
    public void testAddPropertyOverlap() {
        // Add first property
        company1.addProperty(prop1);  // At (1,1,2,2)
        
        // Try to add overlapping property (prop6 overlaps with prop1)
        assertEquals(-4, company1.addProperty(prop6));  // Should return -4 for overlap
        assertEquals(1, company1.getPropertiesCount());  // Count should not change
    }
    
    /**
     * Test addProperty with string parameters (default plot)
     */
    @Test
    public void testAddPropertyStringParametersDefaultPlot() {
        int result = company1.addProperty("String Property", "String City", 1500.0, "String Owner");
        assertEquals(0, result);  // Should be added successfully at index 0
        assertEquals(1, company1.getPropertiesCount());
        
        // Check that property was created correctly
        Property[] properties = company1.getProperties();
        assertEquals("String Property", properties[0].getPropertyName());
        assertEquals("String City", properties[0].getCity());
        assertEquals("String Owner", properties[0].getOwner());
        assertEquals(1500.0, properties[0].getRentAmount(), 0.01);
    }
    
    /**
     * Test addProperty with all string parameters including plot
     */
    @Test
    public void testAddPropertyStringParametersWithPlot() {
        int result = company1.addProperty("Plot Property", "Plot City", 2000.0, "Plot Owner", 3, 3, 2, 2);
        assertEquals(0, result);  // Should be added successfully
        assertEquals(1, company1.getPropertiesCount());
        
        // Check property and plot
        Property[] properties = company1.getProperties();
        assertEquals("Plot Property", properties[0].getPropertyName());
        assertEquals(3, properties[0].getPlot().getX());
        assertEquals(3, properties[0].getPlot().getY());
        assertEquals(2, properties[0].getPlot().getWidth());
        assertEquals(2, properties[0].getPlot().getDepth());
    }
    
    /**
     * Test getTotalRent method
     */
    @Test
    public void testGetTotalRent() {
        // Initially should be 0
        assertEquals(0.0, company1.getTotalRent(), 0.01);
        
        // add properties and check total - doing the math by hand
        company1.addProperty(prop1);  // 2847.25
        assertEquals(2847.25, company1.getTotalRent(), 0.01);
        
        company1.addProperty(prop2);  // 3254.80
        assertEquals(6102.05, company1.getTotalRent(), 0.01);  // 2847.25 + 3254.80
        
        company1.addProperty(prop3);  // 2195.50
        assertEquals(8297.55, company1.getTotalRent(), 0.01);  // 2847.25 + 3254.80 + 2195.50
    }
    
    /**
     * Test getHighestRentPropperty method
     */
    @Test
    public void testGetHighestRentProperty() {
        // Should return null when no properties
        assertNull(company1.getHighestRentProperty());
        
        // add properties with different rents - prop4 should be highest
        company1.addProperty(prop1);  // 2847.25
        company1.addProperty(prop4);  // 3742.00 (highest)
        company1.addProperty(prop3);  // 2195.50
        
        Property highest = company1.getHighestRentProperty();
        assertNotNull(highest);
        assertEquals("Crystal Lake Estates", highest.getPropertyName());
        assertEquals(3742.00, highest.getRentAmount(), 0.01);
    }
    
    /**
     * Test removeLastProperty method
     */
    @Test
    public void testRemoveLastProperty() {
        // Add some properties
        company1.addProperty(prop1);
        company1.addProperty(prop2);
        company1.addProperty(prop3);
        assertEquals(3, company1.getPropertiesCount());
        
        // Remove last property
        company1.removeLastProperty();
        assertEquals(2, company1.getPropertiesCount());
        
        // check that the right property was removed (should be prop3)
        Property[] properties = company1.getProperties();
        assertEquals("Willowbrook Gardens", properties[0].getPropertyName());
        assertEquals("Harbor View Towers", properties[1].getPropertyName());
        assertNull(properties[2]);  // should be null
        
        // Remove another
        company1.removeLastProperty();
        assertEquals(1, company1.getPropertiesCount());
        
        // Remove last one
        company1.removeLastProperty();
        assertEquals(0, company1.getPropertiesCount());
        
        // Try to remove from empty array (should not crash)
        company1.removeLastProperty();
        assertEquals(0, company1.getPropertiesCount());
    }
    
    /**
     * Test isPropertiesFull method
     */
    @Test
    public void testIsPropertiesFull() {
        assertFalse("Should not be full initially", company1.isPropertiesFull());
        
        // Add properties one by one
        company1.addProperty(prop1);
        assertFalse("Should not be full with 1 property", company1.isPropertiesFull());
        
        company1.addProperty(prop2);
        company1.addProperty(prop3);
        company1.addProperty(prop4);
        assertFalse("Should not be full with 4 properties", company1.isPropertiesFull());
        
        company1.addProperty(prop5);
        assertTrue("Should be full with 5 properties", company1.isPropertiesFull());
    }
    
    /**
     * Test getPropertiesCount method
     */
    @Test
    public void testGetPropertiesCount() {
        assertEquals(0, company1.getPropertiesCount());
        
        company1.addProperty(prop1);
        assertEquals(1, company1.getPropertiesCount());
        
        company1.addProperty(prop2);
        assertEquals(2, company1.getPropertiesCount());
        
        company1.removeLastProperty();
        assertEquals(1, company1.getPropertiesCount());
    }
    
    /**
     * Test isMangementFeeValid method
     */
    @Test
    public void testIsManagementFeeValid() {
        // Test valid fees
        ManagementCompany validFee1 = new ManagementCompany("Test", "123", 0.0);
        assertTrue("0% should be valid", validFee1.isMangementFeeValid());
        
        ManagementCompany validFee2 = new ManagementCompany("Test", "123", 50.0);
        assertTrue("50% should be valid", validFee2.isMangementFeeValid());
        
        ManagementCompany validFee3 = new ManagementCompany("Test", "123", 100.0);
        assertTrue("100% should be valid", validFee3.isMangementFeeValid());
        
        // Test invalid fees
        ManagementCompany invalidFee1 = new ManagementCompany("Test", "123", -1.0);
        assertFalse("Negative fee should be invalid", invalidFee1.isMangementFeeValid());
        
        ManagementCompany invalidFee2 = new ManagementCompany("Test", "123", 101.0);
        assertFalse("Fee over 100% should be invalid", invalidFee2.isMangementFeeValid());
    }
    
    /**
     * Test getter methods
     */
    @Test
    public void testGetters() {
        assertEquals("Eagle Ridge Property Management", company1.getName());
        assertEquals("742859630", company1.getTaxID());
        assertEquals(8.75, company1.getMgmFeePer(), 0.01);
        assertNotNull(company1.getProperties());
        assertNotNull(company1.getPlot());
        
        // Test that properties array has correct size
        assertEquals(ManagementCompany.MAX_PROPERTY, company1.getProperties().length);
    }
    
    /**
     * Test setter methods
     */
    @Test
    public void testSetters() {
        ManagementCompany testCompany = new ManagementCompany();
        
        testCompany.setName("New Name");
        assertEquals("New Name", testCompany.getName());
        
        testCompany.setTaxID("999888777");
        assertEquals("999888777", testCompany.getTaxID());
        
        testCompany.setMgmFee(15.5);
        assertEquals(15.5, testCompany.getMgmFeePer(), 0.01);
        
        Plot newPlot = new Plot(5, 5, 20, 20);
        testCompany.setPlot(newPlot);
        assertEquals(newPlot, testCompany.getPlot());
    }
    
    /**
     * Test toString method
     */
    @Test
    public void testToString() {
        // add some properties to test toString
        company1.addProperty(prop1);  // 2847.25
        company1.addProperty(prop2);  // 3192.80
        
        String result = company1.toString();
        
        // check that it contains company info
        assertTrue("Should contain company name", result.contains("Eagle Ridge Property Management"));
        assertTrue("Should contain tax ID", result.contains("742859630"));
        
        // check that it contains property information
        assertTrue("Should contain first property", result.contains("Willowbrook Gardens,Rockville,Elena Rodriguez,2847.25"));
        assertTrue("Should contain second property", result.contains("Harbor View Towers,Columbia,Brandon Mitchell,3254.8"));
        
        // check that it contains management fee calculation
        // total rent: 2847.25 + 3254.80 = 6102.05, Fee: 6102.05 * 8.75% = 533.929375
        assertTrue("Should contain total management fee", result.contains("533.9"));
        
        // Check for proper formatting
        assertTrue("Should contain underscores", result.contains("______________________________________________________"));
    }
    
    /**
     * Test constants
     */
    @Test
    public void testConstants() {
        assertEquals(5, ManagementCompany.MAX_PROPERTY);
        assertEquals(10, ManagementCompany.MGMT_WIDTH);
        assertEquals(10, ManagementCompany.MGMT_DEPTH);
    }
}