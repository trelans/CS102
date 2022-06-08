/**
 * __lab01___
 * @author __Kutay Senyigit___
 * @version __10 FEB 2021__
 */
public class PolynomialTester {

    public static void main(String[] args) {
        // Creating type 1 Polynomial => P(x) = 0
        Polynomial polynomialType1;
        // Creating type 2 Polynomial => P(x) ax^b
        Polynomial polynomialType2;
        // Creating type 3 Polynomial => P(x) ax^b + dx^c ...
        Polynomial polynomialType3;
        // Creating double array for type 3 polynomial
        double[] poly=  {2 , -3  };

        // Creating instances

        polynomialType1 = new Polynomial();   // 0
	    polynomialType2 = new Polynomial(2 , -3);  // -3x^2
	    polynomialType3 = new Polynomial(poly);  // 2 - 3x^1

	    // Testing to String
        System.out.println("Polynomial Type -1-");
        System.out.println(polynomialType1);
        System.out.println("Polynomial Type -2-");
        System.out.println(polynomialType2);
        System.out.println("Polynomial Type -3-");
        System.out.println(polynomialType3 + "\n");

        // Testing GetCoefficients
        System.out.println("Coefficient of Polynomial Type -1-");
        System.out.println(polynomialType1.getCoefficients(0));
        System.out.println("Coefficient of Polynomial Type -2-");
        System.out.println(polynomialType2.getCoefficients(2));
        System.out.println("Coefficients of Polynomial Type -3-");
        System.out.println(polynomialType3.getCoefficients(1) + "\n");

        // Testing getDegree
        System.out.println("Polynomial Type 1's degree is " + polynomialType1.getDegree());
        System.out.println("Polynomial Type 2's degree is " + polynomialType2.getDegree());
        System.out.println("Polynomial Type 3's degree is " + polynomialType3.getDegree() + "\n");


        // Evaluating polynomials
        System.out.println("P(x) for x=2");
        System.out.println("Evaluation for Polynomial Type -1-");
        System.out.println( "P(2) = " + polynomialType1.eval(2));
        System.out.println("Evaluation for Polynomial Type -2-");
        System.out.println( "P(2) = " + polynomialType2.eval(2));
        System.out.println("Evaluation for Polynomial Type -3-");
        System.out.println( "P(2) = " + polynomialType3.eval(2));

        // Evaluating polynomials by using horner
        System.out.println("\nCalculated with horner \n");
        System.out.println("P(x) for x=2");
        System.out.println("Evaluation for Polynomial Type -1-");
        System.out.println( "P(2) = " + polynomialType1.eval2(2));
        System.out.println("Evaluation for Polynomial Type -2-");
        System.out.println( "P(2) = " + polynomialType2.eval2(2));
        System.out.println("Evaluation for Polynomial Type -3-");
        System.out.println( "P(2) = " + polynomialType3.eval2(2));




    }
}
