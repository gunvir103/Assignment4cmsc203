/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: The Property class represents a rental property with information about
 *              its name, city, owner, rent amount, and plot location. It uses aggregation
 *              to contain a Plot object.
 * Due: MM/DD/YYYY
 * Platform/compiler: IntelliJ IDEA / Java
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Gunvir Lubana
*/

public class Property {
    
    // Private fields for property information
    private String propertyName;
    private String city;
    private String owner;
    private double rentAmount;
    private Plot plot;  // Aggregation - Property HAS-A Plot
    
    /**
     * Default constructor - creates a property with default values
     */
    public Property() {
        // Initialize with empty strings and zero rent
        this.propertyName = "";
        this.city = "";
        this.owner = "";
        this.rentAmount = 0.0;
        this.plot = new Plot();  // Create default plot at (0,0) with size 1x1
    }
    
    /**
     * Constructor with property information but default plot
     * @param propertyName name of the property
     * @param city city where property is located
     * @param rentAmount monthly rent amount
     * @param owner name of the property owner
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();  // Default plot at (0,0) with size 1x1
    }
    
    /**
     * Constructor with all property information including plot details
     * @param propertyName name of the property
     * @param city city where property is located
     * @param rentAmount monthly rent amount
     * @param owner name of the property owner
     * @param x x coordinate of the plot
     * @param y y coordinate of the plot
     * @param width width of the plot
     * @param depth depth of the plot
     */
    public Property(String propertyName, String city, double rentAmount, String owner, 
                   int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        // Create a new plot with the given coordinates
        this.plot = new Plot(x, y, width, depth);
    }
    
    /**
     * Copy constructor - creates a deep copy of another property
     * @param otherProperty the property to copy from
     */
    public Property(Property otherProperty) {
        // Copy all the string fields
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.owner = otherProperty.owner;
        this.rentAmount = otherProperty.rentAmount;
        
        // Deep copy the plot using Plot's copy constructor
        // This ensures we have our own plot object, not a reference to the original
        this.plot = new Plot(otherProperty.plot);
    }
    
    // Getter methods
    /**
     * Gets the property name
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }
    
    /**
     * Gets the city
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Gets the owner name
     * @return the owner name
     */
    public String getOwner() {
        return owner;
    }
    
    /**
     * Gets the rent amount
     * @return the monthly rent amount
     */
    public double getRentAmount() {
        return rentAmount;
    }
    
    /**
     * Gets the plot
     * @return the plot object
     */
    public Plot getPlot() {
        return plot;
    }
    
    // Setter methods
    /**
     * Sets the property name
     * @param propertyName the property name to set
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /**
     * Sets the city
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Sets the owner name
     * @param owner the owner name to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
     * Sets the rent amount
     * @param rentAmount the rent amount to set
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    
    /**
     * Sets the plot
     * @param plot the plot to set
     */
    public void setPlot(Plot plot) {
        this.plot = plot;
    }
    
    /**
     * Returns a string representation of the property
     * @return string in format "propertyName,city,owner,rentAmount"
     */
    public String toString() {
        // Build the string with commas between values
        String result = propertyName + "," + city + "," + owner + "," + rentAmount;
        return result;
    }
}