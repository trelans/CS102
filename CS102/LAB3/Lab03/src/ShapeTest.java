/**
 * __Lab03___
 * @author __Kutay Senyigit___
 * @version __2 MARCH 2021__
 */
public class ShapeTest {
    public static void main(String[] args) {
        Shape2D shapeObjects[];
        Rectangle rectangle = new Rectangle(2,3,8,15);
        Circle circle = new Circle(13,15,3.0);
        Square sq = new Square(-2,-5,5);
        Square sq2 = new Square(-2,-5,5);
        Square sq3 = new Square(-1,-5,5);
        Square sq4 = null;

        shapeObjects = new Shape2D[]{new Rectangle(2, 3, 8, 15),
                new Square(-2, -5, 5),
                new Circle(13, 15, 3.0)};
        System.out.println("________________________________________");
        // Testing findLargestArea
        System.out.println("\nTesting LongestArea");
        System.out.println(findLargestArea(shapeObjects) +" has the largest area");
        System.out.println("________________________________________");

        // Testing findLongestPerimeter
        System.out.println("\nTesting LongestPerimeter");
        System.out.println(findLongestPerimeter(shapeObjects) +" has the largest perimeter");
        System.out.println("________________________________________");

        // Testing Distance
        System.out.println("\nTesting Distance!\nDistance between shape rectangle shape circle is " + rectangle.calculateDistance(circle));
        System.out.println("Distance between shape rectangle shape square is " + rectangle.calculateDistance(sq));
        System.out.println("Distance between shape circle shape square is " + circle.calculateDistance(sq));
        System.out.println("________________________________________");

        // Testing Equals
        System.out.println("\nTesting equals!\nsq and sq2  are equal?\n" + sq.equals(sq2));
        System.out.println("sq2 and sq3  are equal?\n" + sq2.equals(sq3));
        System.out.println("sq3 and sq4  are equal?\n" + sq3.equals(sq4));
        System.out.println("sq and circle  are equal?\n" + sq.equals(circle));

    }
    /**
     * This method finds the Shape2D object with a Largest Area in a particular array
     * @param shapeObjects is Shape2D array
     * @return Shape2D with a largest area in that array
     */
    public static Shape2D findLargestArea(Shape2D[] shapeObjects) {
        double max = 0;
        Shape2D shapeWithMaxArea = null;
        for (Shape2D s : shapeObjects) {
            if (s.calculateArea() >= max) {
               max = s.calculateArea();
               shapeWithMaxArea = s;
            }
        }
        return shapeWithMaxArea;
    }
    /**
     * This method finds the Shape2D object with a longest perimeter in a particular array
     * @param shapeObjects is Shape2D array
     * @return Shape2D with a longest perimeter in that array
     */
    public static Shape2D findLongestPerimeter(Shape2D[] shapeObjects) {
        double max = 0;
        Shape2D shapeWithMaxPerimeter = null;
        for (Shape2D s : shapeObjects) {
            if (s.calculatePerimeter() >= max) {
                max = s.calculatePerimeter();
                shapeWithMaxPerimeter = s;
            }
        }
        return shapeWithMaxPerimeter;
    }
}
