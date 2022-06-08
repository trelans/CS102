//Square Class
public class Square extends Shape2D{
    // properties
    double sideLength;
    // constructor
    public Square(int x, int y , double sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }
    // methods
    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "[Square] " + super.toString() + " Side Length: " + sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Square && super.equals(o)) {
            Square s = (Square) o;
            if ( s.sideLength == sideLength ) {
                return true;
            }
        }
        return false;
    }
}