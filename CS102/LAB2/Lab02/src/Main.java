/**
 * __Lab02___
 * @author __Kutay Senyigit___
 * @version __16 FEB 2021__
 */
public class Main {

    public static void main(String[] args) {
        double coefficientOfPolynomial1[] = {3 ,4 ,1}; // 3 + 4x + x^2
        double coefficientOfPolynomial2[] = { 1 , 1 }; // 1 + x

        double coefficientOfPolynomial3[] = {3 , 4, 1 }; // 3 + 4x + 1x^2
        double coefficientOfPolynomial4[] = { 2, 1 }; // 2 + x
        Polynomial polynomial1 = new Polynomial(coefficientOfPolynomial1);
        Polynomial polynomial2 = new Polynomial(coefficientOfPolynomial2);

        // For division test
        Polynomial polynomial3 = new Polynomial(coefficientOfPolynomial3);
        Polynomial polynomial4 = new Polynomial(coefficientOfPolynomial4);

        Polynomial polynomialResult;



        System.out.println("Polynomial-1\n" + polynomial1);
        System.out.println("Polynomial-2\n" + polynomial2);

        // P1(X) = 3 + 4x + x^2  +  P2(x) = 1 + x
        // testing add method
        polynomialResult =  polynomial1.add(polynomial2);
        System.out.println("\nP1(x) + P2(x)\n" + polynomialResult);

        // P1(X) = 3 + 4x + x^2  -  P2(x) = 1 + x
        // testing sub method
        polynomialResult =  polynomial1.sub(polynomial2);
        System.out.println("\nP1(x) - P2(x)\n" + polynomialResult);

        // P1(X) = 3 + 4x + x^2  *  P2(x) = 1 + x
        // testing mul method
        polynomialResult =  polynomial2.mul(polynomial1);
        System.out.println("\nP1(x) * P2(x)\n" + polynomialResult);

        // P1(X) = 3 + 4x + x^2    P2(x) = 1 + x
        // testing compose method
        polynomialResult =  polynomial1.compose(polynomial2);
        System.out.println("\nP1(P2(x))\n" + polynomialResult);

        // testing div method
        // P3(X) = 3 + 4x + 1x^2  / P4(X) = 2 + 1x
        polynomialResult =  polynomial3.div(polynomial4);
        System.out.println("\nP3(x) / P4(x)\n" + polynomialResult);

    }
}
