/**
 * __Lab02___
 * @author __Kutay Senyigit___
 * @version __16 FEB 2021__
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
    public Polynomial() {
        y = 0;
        typeOfPolynomial = 0;
        coefficients = new double[] {0};


    }
    public Polynomial(int d , double c ) {
        typeOfPolynomial = 1;
        this.d = d;
        this.c = c;
        coefficients = new double[d+1];
        for (int i = 0 ; i < coefficients.length - 1  ; i++) {
            coefficients[i] = 0;
        }
        coefficients[d] = c;
        copyOfAbsCoefficients = coefficients.clone();
        operations = new String[coefficients.length];
    }
    public Polynomial(double[] coefficients) {
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
        int d = 0;
        for( int i = 0; i < coefficients.length; i++ )
            if( coefficients[ i ] != 0 ) d = i;
        return d;
/*        if (typeOfPolynomial == 2) {
            double zero = 0 ;
            int index = coefficients.length -1;
            while (coefficients[index] == zero  ) {

                index--;
                System.out.println("SCJDSFDSFDSFSDF");
            }
            System.out.println(coefficients[index]);
            d = index;
            return d;

        }

        else if (typeOfPolynomial == 0) {
            return 0;
        }
        else {
            return d;
        }*/
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
        if(typeOfPolynomial == 2 || typeOfPolynomial == 1) {
            copyOfAbsCoefficients = coefficients.clone();
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


        else if (typeOfPolynomial == 2 || typeOfPolynomial == 1) {
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
    public Polynomial add( Polynomial p2 ){
        Polynomial p1 = this;
        //Creates empty polynomial my comparing two polynomials degree and it takes the biggest degree
        Polynomial sumOfPolynomials = new Polynomial( this.getBiggestDegree(p2),  0);

        //Adds all P1's coefficients to empty polynomial
        for( int i = 0; i <= p1.getDegree(); i++ ) {
            sumOfPolynomials.coefficients[ i ] += p1.coefficients[ i ];
        }

        //Adds all P2's coefficients to empty polynomial
        for( int i = 0; i <= p2.getDegree(); i++ ) {
            sumOfPolynomials.coefficients[ i ] += p2.coefficients[ i ];
        }

        sumOfPolynomials.d = sumOfPolynomials.getDegree();
        //returns the result
        return sumOfPolynomials;
    }

    public Polynomial sub (Polynomial p2) {
        Polynomial p1 = this;
        //Creates empty polynomial my comparing two polynomials degree and it takes the biggest degree
        Polynomial subOfPolynomials = new Polynomial( this.getBiggestDegree(p2),  0);

        // 2 + 2x
        // 1 + x

        //Adds all P1's coefficients to empty polyniomial
        for( int i = 0; i <= p1.getDegree(); i++ ) {
            subOfPolynomials.coefficients[ i ] += p1.coefficients[ i ];
        }

        //subs all P2's coefficients to empty polyniomial
        for( int i = 0; i <= p2.getDegree(); i++ ) {
            subOfPolynomials.coefficients[ i ] -= p2.coefficients[ i ];
        }

        subOfPolynomials.d = subOfPolynomials.getDegree();
        //returns the result
        return subOfPolynomials;

    }
    public Polynomial mul (Polynomial p2) {
        // sum of the polynomials' degree
        int sumOfDegrees = getDegree() + p2.getDegree();
        Polynomial p1 = this;
        //Creates empty polynomial it creates its degrees by taking polynomials' degrees sum
        Polynomial result = new Polynomial( sumOfDegrees, 0 );
            // Finds result
            for( int i = 0; i <= p1.getDegree(); i++ ) {
                for( int j = 0; j <= p2.getDegree(); j++ ) {
                    result.coefficients[ i + j ] += ( p1.coefficients[ i ] * p2.coefficients[ j ] );

                }

            }

            result.d = result.getDegree();
        //returns the result
        return result;
        }

    public Polynomial compose( Polynomial p2){
        Polynomial p1 = this;
        //Creates empty polynomial
        Polynomial result = new Polynomial( 0, 0 );
        // Finds result
        for( int i = p1.getDegree(); i >= 0; i-- ){
            // create polynomial for every term in p1
            Polynomial term = new Polynomial( 0, p1.coefficients[ i ] );
            // calculates the result
            result = term.add( p2.mul( result ) );
        }
        //returns the result
        return result;
    }


    public Polynomial div ( Polynomial p2 ) {
        Polynomial p1 = this;
        // t will mi division of the p1's biggest degree term and p2's biggest degree term
        Polynomial t = null;
        //Creates empty polynomial
        Polynomial result = new Polynomial( 0, 0 ); // 3 + 4x+ x^2 + 3x^3 + 2x^5
        while(p1.getDegree() >= p2.getDegree() ){
            // Finding degrees
            int leadP1 = p1.getDegree();
            int leadP2 = p2.getDegree();
            // initializes t  by  division of p1's biggest degree term and p2's biggest degree term
            t = new Polynomial(leadP1-leadP2 , p1.coefficients[leadP1]/p2.coefficients[leadP2]);
            // calculates
            p1 = p1.sub(t.mul(p2));
            result = result.add(t);
        }
        //returns the result
        return result;

    }

    public void setCoefficients(int index , double coefficient ) {
        this.coefficients[index] = coefficient;
    }


    // Compares two polynomial and takes the biggest degree.
    public int getBiggestDegree ( Polynomial p2) {
        // returns biggest degree
        if (getDegree() >= p2.getDegree()) {
            return getDegree();
        }
        else
            return p2.getDegree();
    }

}
