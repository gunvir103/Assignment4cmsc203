/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: The ManagementCompany class manages a collection of rental properties.
 *              It tracks properties in an array, ensures they don't overlap, calculates
 *              total rent, and applies management fees. Maximum of 5 properties allowed.
 * Due: MM/DD/YYYY
 * Platform/compiler: IntelliJ IDEA / Java
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Gunvir Lubana
*/

public class ManagementCompany {
    
    // static constants for the class
    public static final int MAX_PROPERTY = 5;    // maximum number of properties
    public static final int MGMT_WIDTH = 10;     // default width of management plot
    public static final int MGMT_DEPTH = 10;     // default depth of management plot
    
    // private fields for company information
    private String name;                         // company name
    private String taxID;                        // tax ID number
    private double mgmFee;                       // management fee percentage
    private Property[] properties;               // array to hold properties
    private Plot plot;                            // the company's plot
    private int numberOfProperties;              // current number of properties
    
    /**
     * Default constructor - creates a management company with default values
     */
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFee = 0.0;
        this.properties = new Property[MAX_PROPERTY];  // create array with max size
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);  // default plot
        this.numberOfProperties = 0;  // start with no properties
    }
    
    /**
     * Constructor with company information and default plot
     * @param name the company name
     * @param taxID the tax ID
     * @param mgmFee the management fee percentage
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);  // default plot
        this.numberOfProperties = 0;
    }
    
    /**
     * Constructor with company information and custom plot
     * @param name the company name
     * @param taxID the tax ID
     * @param mgmFee the management fee percentage
     * @param x x coordinate of company plot
     * @param y y coordinate of company plot
     * @param width width of company plot
     * @param depth depth of company plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee, 
                            int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);  // custom plot
        this.numberOfProperties = 0;
    }
    
    /**
     * Copy constructor - creates a deep copy of another management company
     * @param otherCompany the company to copy from
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);  // deep copy the plot
        this.numberOfProperties = otherCompany.numberOfProperties;
        
        // create new array and deep copy all properties
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            if (otherCompany.properties[i] != null) {
                this.properties[i] = new Property(otherCompany.properties[i]);
            }
        }
    }
    
    /**
     * Adds a property to the management company
     * @param property the property to add
     * @return -1 if array is full, -2 if property is null, -3 if not encompassed,
     *         -4 if overlaps existing property, otherwise the index where added
     */
    public int addProperty(Property property) {
        // check if property is null
        if (property == null) {
            return -2;
        }
        
        // check if array is full
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }
        
        // check if property plot is within management company plot
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        
        // check if property overlaps with any existing property
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        
        // if all checks pass, add the property using copy constructor
        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        
        // return the index where it was added
        return numberOfProperties - 1;
    }
    
    /**
     * Adds a property with basic information (uses default plot)
     * @param name property name
     * @param city property city
     * @param rent monthly rent
     * @param owner property owner
     * @return result code from addProperty
     */
    public int addProperty(String name, String city, double rent, String owner) {
        // create a property with default plot and add it
        Property newProperty = new Property(name, city, rent, owner);
        return addProperty(newProperty);  // call the main addProperty method
    }
    
    /**
     * Adds a property with all information including plot details
     * @param name property name
     * @param city property city
     * @param rent monthly rent
     * @param owner property owner
     * @param x x coordinate of plot
     * @param y y coordinate of plot
     * @param width width of plot
     * @param depth depth of plot
     * @return result code from addProperty
     */
    public int addProperty(String name, String city, double rent, String owner,
                          int x, int y, int width, int depth) {
        // Create a property with specified plot and add it
        Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(newProperty);  // Call the main addProperty method
    }
    
    /**
     * Calculates and returns the total rent from all properties
     * @return total rent amount
     */
    public double getTotalRent() {
        double total = 0.0;
        
        // loop through all properties and sum their rent
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                total += properties[i].getRentAmount();
            }
        }
        
        return total;
    }
    
    /**
     * Finds and returns the property with the highest rent
     * @return the property with maximum rent
     */
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        
        // start with first property as highest
        Property highestRentProperty = properties[0];
        double highestRent = properties[0].getRentAmount();
        
        // check all other properties
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > highestRent) {
                highestRent = properties[i].getRentAmount();
                highestRentProperty = properties[i];
            }
        }
        
        return highestRentProperty;
    }
    
    /**
     * Removes the last property in the array
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;  // Nullify the last property
            numberOfProperties--;  // Decrease the count
        }
    }
    
    /**
     * Checks if the properties array is full
     * @return true if full, false otherwise
     */
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    /**
     * Gets the count of properties
     * @return number of properties
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    /**
     * Checks if management fee is valid (between 0 and 100)
     * @return true if valid, false otherwise
     */
    public boolean isMangementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }
    
    // Getter methods
    /**
     * Gets the company name
     * @return the company name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the tax ID
     * @return the tax ID
     */
    public String getTaxID() {
        return taxID;
    }
    
    /**
     * Gets the properties array
     * @return the properties array
     */
    public Property[] getProperties() {
        return properties;
    }
    
    /**
     * Gets the management fee percentage
     * @return the management fee percentage
     */
    public double getMgmFeePer() {
        return mgmFee;
    }
    
    /**
     * Gets the company plot
     * @return the plot
     */
    public Plot getPlot() {
        return plot;
    }
    
    // Setter methods
    /**
     * Sets the company name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the tax ID
     * @param taxID the tax ID to set
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
    
    /**
     * Sets the management fee
     * @param mgmFee the fee to set
     */
    public void setMgmFee(double mgmFee) {
        this.mgmFee = mgmFee;
    }
    
    /**
     * Sets the plot
     * @param plot the plot to set
     */
    public void setPlot(Plot plot) {
        this.plot = plot;
    }
    
    /**
     * Returns a string representation of the management company and all properties
     * @return formatted string with company info, properties, and total fee
     */
    public String toString() {
        // Build the string piece by piece
        String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        result += "______________________________________________________\n";
        
        // Add each property
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                result += properties[i].toString() + "\n";
            }
        }
        
        result += "______________________________________________________\n";
        
        // Calculate and add total management fee
        double totalRent = getTotalRent();
        double totalFee = (totalRent * mgmFee) / 100.0;  // Calculate fee from percentage
        
        result += "\n total management Fee: " + totalFee;
        
        return result;
    }
}