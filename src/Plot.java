/*
 * Class: CMSC203 CRN 40539
 * Instructor: Grigoriy Grinberg
 * Description: The Plot class represents a rectangular plot of land with x,y coordinates 
 *              for the upper left corner and width/depth dimensions. It can check if
 *              plots overlap or if one plot encompasses another.
 * Due: MM/DD/YYYY
 * Platform/compiler: IntelliJ IDEA / Java
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Gunvir Lubana
*/

public class Plot {
    
    // private fields for the plot coordinates and dimensions
    private int x;      // x coordinate of upper left corner
    private int y;      // y coordinate of upper left corner  
    private int width;  // horizontal size of the plot
    private int depth;  // vertical size of the plot (i think this is like height)
    
    /**
     * Default constructor - creates a plot at (0,0) with size 1x1
     */
    public Plot() {
        // initialize to default values
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
    
    /**
     * Parameterized constructor - creates a plot with given values
     * @param x the x coordinate of upper left corner
     * @param y the y coordinate of upper left corner
     * @param width the width of the plot
     * @param depth the depth of the plot
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    /**
     * Copy constructor - creates a new plot with same values as another plot
     * @param otherPlot the plot to copy from
     */
    public Plot(Plot otherPlot) {
        // make sure to copy each field individually (deep copy stuff)
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }
    
    /**
     * Checks if this plot overlaps with another plot
     * @param plot the plot to check against
     * @return true if the plots overlap, false otherwise
     */
    public boolean overlaps(Plot plot) {
        // two rectangles dont overlap if one is completely to the left of the other
        if (this.x + this.width <= plot.x) {
            return false;  // this plot is completely to the left
        }
        if (plot.x + plot.width <= this.x) {
            return false;  // other plot is completely to the left
        }
        
        // two rectangles dont overlap if one is completely above the other
        if (this.y + this.depth <= plot.y) {
            return false;  // this plot is completely above
        }
        if (plot.y + plot.depth <= this.y) {
            return false;  // other plot is completely above
        }
        
        // if none of the above conditions are true, the plots must overlap
        return true;
    }
    
    /**
     * Checks if this plot encompasses (contains) another plot
     * The other plot must be completely inside this plot (edges can touch)
     * @param plot the plot to check
     * @return true if this plot encompasses the other plot, false otherwise
     */
    public boolean encompasses(Plot plot) {
        // check if all edges of the other plot are within or on the edges of this plot
        boolean leftCheck = plot.x >= this.x;  // other plot's left edge is at or right of this plot's left
        boolean rightCheck = (plot.x + plot.width) <= (this.x + this.width);  // other plot's right edge is at or left of this plot's right
        boolean topCheck = plot.y >= this.y;  // other plot's top edge is at or below this plot's top
        boolean bottomCheck = (plot.y + plot.depth) <= (this.y + this.depth);  // other plot's bottom edge is at or above this plot's bottom
        
        // all conditions must be true for this plot to encompas the other
        if (leftCheck && rightCheck && topCheck && bottomCheck) {
            return true;
        } else {
            return false;
        }
    }
    
    // getter methods
    /**
     * Gets the x coordinate
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Gets the y coordinate
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Gets the width
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Gets the depth
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }
    
    // setter methods
    /**
     * Sets the x coordinate
     * @param x the x coordinate to set
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Sets the y coordinate
     * @param y the y coordinate to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Sets the width
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Sets the depth
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    /**
     * Returns a string representation of the plot
     * @return string in format "x,y,width,depth"
     */
    public String toString() {
        // build the string with commas between values (no spaces)
        String result = x + "," + y + "," + width + "," + depth;
        return result;
    }
}