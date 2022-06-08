// Rectangle class
public class Rectangle extends Shape2D {
    // properties
    double height;
    double width;
    // constructor
    public Rectangle(int x, int y , double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return (height + width) * 2;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "[Rectangle] " + super.toString() + " Height: " + height + " Width: " + width;
    }

    @Override
    public boolean equals(Object o) {
       if (o instanceof Rectangle && super.equals(o)) {
           Rectangle r = (Rectangle) o;
           if ( r.height == height && r.width == width ) {
                return true;
           }
       }
       return false;
    }
}