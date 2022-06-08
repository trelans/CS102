import java.util.ArrayList;
/**
 * __lab06___
 * @author __Kutay Senyigit___
 * @version __14 APR 2021__
 */
public class Main {

    public static void main(String[] args) {

        // TEST A removeCharR
        System.out.println( removeCharR("wdwkeqrrwqewrwqrqwrr"));

        // TEST B DECIMAL TO HEXADECIMAL
        System.out.println(decimalToHexadecimalConverter(23));

        // TEST C LEXICOGRAPHICAL TEST
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList1 = new ArrayList<String>();

        // CASE : 1 WILL BE TRUE
        arrayList.add("A");
        arrayList.add("B");
        System.out.println(IsLexicographic(arrayList));

        // CASE : 2 WILL BE FALSE
        arrayList1.add("A");
        arrayList1.add("S");
        arrayList1.add("B");
        System.out.println(IsLexicographic(arrayList1));

        // TEST D REVERSE STRING
        reverse("KADEIA");

        // TEST E FINDING NUMBER SPECIFIC DIGIT WITH INCREASE BETWEEN DIGITS
        findNumbers(3);

    }

    // (a) A recursive method that computes a new string where all occurrences of the
    //character "r" in an input string have been removed.
    public static String removeCharR(String word) {
        // if word length is 0 return the same word
        if(word.length() == 0) {
            return word;
        }

        else {
            // If the first char is "r" removes the first char and calls the method recursively
            if(word.charAt(0) == 'r') {
                return removeCharR(word.substring(1));
            }
            // Returns the first char and calls the method recursively
            else {
                return word.charAt(0) + removeCharR(word.substring(1));
            }
        }
    }

    //(b) A recursive method that takes a decimal value as an int parameter and returns the
    //hexadecimal equivalent of it as a string. For example, if your method is passed the integer
    //value 1249 (base ten) it should return the string "4E1".
    public static String decimalToHexadecimalConverter(int decimal) {
        String result = "";
        int remainder = decimal % 16;
        // if decimal 0, ends recursion
        if (decimal == 0) {
            return "";
        }
        else {
            switch (remainder) {
                case 10:
                    result = "A";
                    break;
                case 11:
                    result = "B";
                    break;
                case 12:
                    result = "C";
                    break;
                case 13:
                    result = "D";
                    break;
                case 14:
                    result = "E";
                    break;
                case 15:
                    result = "F";
                    break;
                default:
                    result = remainder + result;
                    break;
            }
            return decimalToHexadecimalConverter(decimal / 16) + result;
        }
    }


    // (c) Returns true if strings in the array are in lexicographic (effectively alphabetic) order, and false otherwise.
   public static boolean IsLexicographic( ArrayList<String> arrayList)
    {     // takes the arraylist's size
        int n = arrayList.size();
            // This will end the recursion
        if (n == 1 || n == 0)
            return true;
            // checking lexicographic order by starting last two element
        if (arrayList.get(n - 1).compareTo(arrayList.get(n-2)) < 0 )
            return false;
            // deleting last element in arraylist
            arrayList.remove(n - 1);
        // recursion
        return IsLexicographic(arrayList);
    }


    // (d) A recursive method that prints its String argument in reverse direction.
    public static void reverse(String reverse) {
        // checks whether the string length is null or 1
        if ((reverse==null)||(reverse.length() <= 1))
            System.out.println(reverse);
        else
        {   //prints the last char
            System.out.print(reverse.charAt(reverse.length() - 1));
            // deletes last char and applies recursion
            reverse(reverse.substring(0,reverse.length() - 1));
        }
    }
    
    //  (e) Prints all n-digit even numbers in which
    //each digit of the number, from its most-significant to least-significant digits, is greater than
    //the previous one (that is, for instance, the number 124 is ok, but the number 142 is not,
    //since 2 is less than 4).

    public static void findNumbers( int n)
    {
            // tries all numbers at that digit
        for (int i = (int) Math.pow(10,n-1) ; i < Math.pow(10, n); i++)
        {
            if (IsMeets(i) && IsEven(i)) {
                System.out.println(i);
            }
        }
    }

    // Checks conditions recursively if it meets then return true
    public static boolean IsMeets(int number) {
        String str = Integer.toString(number);
        int n = str.length();
        if (n == 1 ) {
            return true;
        }
        if (str.charAt(n-1) > str.charAt(n-2)) {
            return IsMeets(Integer.parseInt(str.substring(0,n-1)));
        }
        else return false;

    }

    // Checks the number, if it is even returns true
    public static boolean IsEven(int number) {
        if (number % 2 == 0) return true;
        return false;
    }



}
