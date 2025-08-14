/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: Student test class for the Plot class. Tests all public methods
 *              including constructors, getters, setters, overlaps, encompasses, and toString.
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

public class PlotTestStudent {
    
    private Plot plot1, plot2, plot3, plot4;

    @Before
    public void setUp() throws Exception {
        // Create test plots for various test scenarios - using randomized realistic values
        plot1 = new Plot(7, 12, 8, 6);         // Main test plot at (7,12) size 8x6
        plot2 = new Plot(9, 14, 3, 2);         // Smaller plot inside plot1 at (9,14) size 3x2
        plot3 = new Plot(25, 30, 4, 3);        // Plot completely outside at (25,30) size 4x3
        plot4 = new Plot(13, 16, 5, 4);        // Plot that overlaps with plot1 at (13,16) size 5x4
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = null;
    }

    /**
     * Test the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        Plot defaultPlot = new Plot();
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }
    
    /**
     * Test the parameterized constructor with my own values
     */
    @Test
    public void testParameterizedConstructor() {
        Plot testPlot = new Plot(7, 11, 9, 13);  // just picked some numbers
        assertEquals(7, testPlot.getX());
        assertEquals(11, testPlot.getY());
        assertEquals(9, testPlot.getWidth());
        assertEquals(13, testPlot.getDepth());
    }
    
    /**
     * Test the copy constructor
     */
    @Test
    public void testCopyConstructor() {
        Plot copyPlot = new Plot(plot1);
        // Check that values are copied correctly
        assertEquals(plot1.getX(), copyPlot.getX());
        assertEquals(plot1.getY(), copyPlot.getY());
        assertEquals(plot1.getWidth(), copyPlot.getWidth());
        assertEquals(plot1.getDepth(), copyPlot.getDepth());
        
        // Check that it's a different object (not same reference)
        assertNotSame(plot1, copyPlot);
        
        // Change original and make sure copy isn't affected
        plot1.setX(999);
        assertEquals(7, copyPlot.getX());  // Copy should still have original value
    }
    
    /**
     * Test overlaps method when plots actually overlap
     */
    @Test
    public void testOverlapsTrue() {
        // plot1 (1,3,5,4) and plot4 (4,5,3,2) should overlap - I checked this by hand
        assertTrue("Plot1 and Plot4 should overlap", plot1.overlaps(plot4));
        assertTrue("Plot4 and Plot1 should overlap too", plot4.overlaps(plot1));
        
        // plot1 (1,3,5,4) and plot2 (2,4,2,2) should overlap since plot2 is inside plot1
        assertTrue("Plot1 and Plot2 should overlap", plot1.overlaps(plot2));
        assertTrue("Plot2 and Plot1 should overlap back", plot2.overlaps(plot1));
    }
    
    /**
     * Test overlaps when plots don't overlap at all
     */
    @Test
    public void testOverlapsFalse() {
        // plot1 (1,3,5,4) and plot3 (12,8,3,2) are totally separate
        assertFalse("Plot1 and Plot3 should not overlap", plot1.overlaps(plot3));
        assertFalse("Plot3 and Plot1 should not overlap either", plot3.overlaps(plot1));
        
        // Make a plot that's right next to plot1 but doesn't touch
        Plot nearbyPlot = new Plot(6, 3, 2, 4);  // Starts where plot1 ends
        assertFalse("Nearby plots shouldn't overlap", plot1.overlaps(nearbyPlot));
    }
    
    /**
     * Test edge touching case - I want to make sure touching edges don't count as overlap
     */
    @Test
    public void testOverlapsEdgeCase() {
        // Make a plot that just touches plot1's edge but doesn't overlap
        Plot touchingPlot = new Plot(6, 3, 1, 4);  // plot1 ends at x=6, this starts at x=6
        assertFalse("Just touching edges shouldn't be overlap", plot1.overlaps(touchingPlot));
    }
    
    /**
     * Test encompasses method - plot contains another plot
     */
    @Test
    public void testEncompassesTrue() {
        // plot1 (2,2,6,6) should encompass plot2 (3,4,4,3)
        assertTrue("Plot1 should encompass Plot2", plot1.encompasses(plot2));
        
        // Test plot encompassing itself
        assertTrue("Plot should encompass itself", plot1.encompasses(plot1));
        
        // Test with plot that exactly fits on the boundaries
        Plot boundaryPlot = new Plot(7, 12, 8, 6);  // Same as plot1
        assertTrue("Plot1 should encompass identical plot", plot1.encompasses(boundaryPlot));
    }
    
    /**
     * Test encompasses method - plot does not contain another plot
     */
    @Test
    public void testEncompassesFalse() {
        // plot1 should not encompass plot3 (which is outside)
        assertFalse("Plot1 should not encompass Plot3", plot1.encompasses(plot3));
        
        // plot1 should not encompass plot4 (which extends outside)
        assertFalse("Plot1 should not encompass Plot4", plot1.encompasses(plot4));
        
        // Smaller plot should not encompass larger plot
        assertFalse("Plot2 should not encompass Plot1", plot2.encompasses(plot1));
    }
    
    /**
     * Test encompasses edge case - plot extending outside by 1 unit
     */
    @Test
    public void testEncompassesEdgeCase() {
        // Create a plot that extends outside plot1 by 1 unit
        Plot extendingPlot = new Plot(2, 2, 7, 6);  // Width is 7, extends outside plot1's width of 6
        assertFalse("Plot1 should not encompass plot extending outside", plot1.encompasses(extendingPlot));
    }
    
    /**
     * Test all getter methods
     */
    @Test
    public void testGetters() {
        assertEquals("X coordinate should be 7", 7, plot1.getX());
        assertEquals("Y coordinate should be 12", 12, plot1.getY());
        assertEquals("Width should be 8", 8, plot1.getWidth());
        assertEquals("Depth should be 6", 6, plot1.getDepth());
    }
    
    /**
     * Test all setter methods
     */
    @Test
    public void testSetters() {
        Plot testPlot = new Plot();
        
        testPlot.setX(23);
        assertEquals("X should be set to 23", 23, testPlot.getX());
        
        testPlot.setY(41);
        assertEquals("Y should be set to 41", 41, testPlot.getY());
        
        testPlot.setWidth(17);
        assertEquals("Width should be set to 17", 17, testPlot.getWidth());
        
        testPlot.setDepth(29);
        assertEquals("Depth should be set to 29", 29, testPlot.getDepth());
    }
    
    /**
     * Test toString method format
     */
    @Test
    public void testToString() {
        // Test with plot1 (2,2,6,6)
        assertEquals("toString should match expected format", "7,12,8,6", plot1.toString());
        
        // Test with plot2 (9,14,3,2)
        assertEquals("toString should match expected format", "9,14,3,2", plot2.toString());
        
        // Test with default plot
        Plot defaultPlot = new Plot();
        assertEquals("Default plot toString should be 0,0,1,1", "0,0,1,1", defaultPlot.toString());
    }
}