// Circle Class
public class Circle extends Shape2D {

    // properties
    private double radius;

    // constructor
    public Circle(int x, int y , double radius) {
        super(x, y );
        this.radius = radius;
    }

    // methods
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius ;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius , 2);
    }

    @Override
    public String toString() {
        return "[Circle] " + super.toString() + " Radius: " + radius ;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle && super.equals(o)) {
            Circle c = (Circle) o;
            if ( c.radius == radius) {
                return true;
            }
        }
        return false;
    }
}