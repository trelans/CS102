/**
 * __lab01___
 * @author __Kutay Senyigit___
 * @version __10 FEB 2021__
 */
public class Polynomial {
    // fields
    double [] coefficients ;
    double [] copyOfAbsCoefficients; // all of them +
    String [] operations; // + or -
    int d ;
    double c;
    double y , x;
    // if typeOfPolynomial is 0, then P(x) 0
    // if typeOfPolynomial is 1, then P(x) ax^b
    // if typeOfPolynomial is 2, then P(x) ax^b + dx^c ....
    int typeOfPolynomial;
    // Constructors
    public Polynomial () {
        y = 0;
        typeOfPolynomial = 0;
    }
    public Polynomial ( int d , double c ) {
        this.d = d;
        this.c = c;
        coefficients = new double[d+1];
        for (int i = 0 ; i < coefficients.length - 1  ; i++) {
            coefficients[i] = 0;
        }
        coefficients[d] = c;
        typeOfPolynomial = 1;
    }
    public Polynomial (double[] coefficients) {
        this.coefficients = coefficients;
        operations = new String[coefficients.length];
        copyOfAbsCoefficients = coefficients.clone();
        typeOfPolynomial = 2;
    }
    // methods

    // getters
    public double getCoefficients(int degree) {
        if (typeOfPolynomial == 2) {
            if ( coefficients.length -1 >= degree ) //  1 + x + x^2
            return coefficients[degree];
            else return 0;
        }
        else if (typeOfPolynomial == 1) {
            if (degree == d) return c;
            else return 0;
        }
            return 0;
    }

    public int getDegree() {
        if (typeOfPolynomial == 2)
         return coefficients.length - 1;
        else if (typeOfPolynomial == 0) {
            return 0;
        }
        else {
            return d;
        }
    }
    public double eval(double x) {
    if(typeOfPolynomial == 0)
        return 0;
    else if (typeOfPolynomial == 1) {
        return   c * Math.pow(x, d);
    }
    else  {
        y = 0;
        for (  int a = 0  ; a < coefficients.length ; a++) {
            y = y + ( coefficients[a] * Math.pow(x,a));
        }
        return y;
    }
    }
        //  Calculates with using Horner's Method
    public double eval2(double x) {
        double eval2  = 0;
        // Calculates type 2 with using Heron
        if (typeOfPolynomial == 2  || typeOfPolynomial == 1) {

                for (int i = coefficients.length - 1; i >= 0; i--)
                {
                    eval2 = coefficients[i] + (x * eval2);
                }

        }

        return eval2 ;
    }
    //setters
    /**
     * It takes coefficients and copies the array with making negative member of arrays positive
     * so that they can be used in toString method
     */
    public void setOperationDeterminer() {
        if(typeOfPolynomial == 2) {

            for (  int a = 0  ; a < coefficients.length ; a++) {
              if(copyOfAbsCoefficients[a] < 0) {
                  copyOfAbsCoefficients[a] = copyOfAbsCoefficients[a] * -1;  // deleting "-"
                  operations[a] = " - ";
              }
              else {
                  operations[a] = " + ";
                }
            }

        }
    }
    // toString
    public String toString() {
        String polynomial = "";
        if (typeOfPolynomial == 0){
            return "P(x)= " + "0";
        }

        else if (typeOfPolynomial == 1) {
            return "P(x)= " + c + "x^" + d ;
        }
        else if (typeOfPolynomial == 2) {
            setOperationDeterminer();
            for (  int a = 1  ; a < copyOfAbsCoefficients.length ; a++) {
                if(copyOfAbsCoefficients[a] != 0) {
                    polynomial = polynomial + operations[a] + copyOfAbsCoefficients[a] + "x^" + a ;
                }

            }

        if (coefficients[0] == 0 ) {
                return "P(x)= " + polynomial;
            }
            else {
                return "P(x)= " + coefficients[0]  + polynomial;
            }

        }
        return "error";
    }
}
