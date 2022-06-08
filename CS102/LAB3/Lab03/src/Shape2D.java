// Shape2D class
public abstract class Shape2D {
    // properties
    private int x;
    private int y;

    // constructor
    public Shape2D(int x , int y) {
        this.x = x;
        this.y = y;
    }
    // methods
    public abstract double calculatePerimeter();
    public abstract double calculateArea();

    /**
     * This method calculates distance between two shapes.
     * @param anyShape is Object
     * @return The euclidean distance between the centers of two Shape2D objects. If anyShape
     * parameter is not a Shape2D instance, it should return -1.
     */
    public double calculateDistance( Object anyShape ) {
        Shape2D s = (Shape2D) anyShape;
        if (anyShape instanceof Shape2D) {
            double distance;
            distance = Math.sqrt(Math.pow( x - s.x , 2) +  Math.pow( y - s.y , 2));
            return distance;
        }
        else {
            return -1;
        }

    }

    public String toString() {
        return "( " + x + ", " + y + " )";
    }
    public boolean equals ( Object o) {
        Shape2D s = (Shape2D) o;

        if (o instanceof Shape2D && x == s.x && y == s.y ) {
            return true;
        }
        return false;
    }
}