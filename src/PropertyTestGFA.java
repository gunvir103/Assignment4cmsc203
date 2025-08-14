
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Farnaz Eivazi
 * @version 7/11/2022
 */
public class PropertyTestGFA {
	Property propertyOne;

	@Before
	public void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
	}

	@After
	public void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	public void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
	}

	@Test
	public void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount(), 0.01);
	}

	@Test
	public void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	public void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0",propertyOne.toString());	
	}

}
