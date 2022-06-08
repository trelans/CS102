import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    //constants
    private final int MAX_ALLOWED_INCORRECT_TRIES;
    //properties
    StringBuffer secretWord;
    StringBuffer allLetters;
    StringBuffer usedLetters;
    StringBuffer knownSoFar;

    int numberOfIncorrectTries;

    //my additions
    String[] process;
    boolean isWon;
    String[] words;




    // constructor
    public Hangman()
    {
        secretWord = new StringBuffer();
        allLetters = new StringBuffer();
        usedLetters = new StringBuffer();
        knownSoFar = new StringBuffer();
        MAX_ALLOWED_INCORRECT_TRIES = 6;

        for ( int i = 97; i <= 122; i++ )
        {
            allLetters.append( (char) i );
        }


        numberOfIncorrectTries = 0; // At the start there is no trying so it is 0
        chooseSecretWord();


                for (int a = 0; a < secretWord.length(); a++)
                {
                    knownSoFar.append("*"); // For getting letter number underScore for empty displaying
                }


        //my additions
         words = null;
         process = new String[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++ ) {
            process[i] =  "_";
        }
        isWon = false;
    }



    // methods

    /**
     * This method checks the guessed letter if it is present in the secret word
     * @param letter guessed letter by the player
     * @return number of occurences of given letter in the secret word
     */

    public int tryThis( String letter )
    {
        //is known added in order to fix bug
        boolean isKnown = false;
        int numberOfOccurences;
        numberOfOccurences = 0;
        if ( !getUsedLetters().contains( letter ) && getAllLetters().contains(letter))
        {


            for ( int i = 0; i < secretWord.length(); i ++ )
                {

                    if ( letter.charAt(0) == secretWord.charAt(i) )
                         {
                                numberOfOccurences ++;
                                process[i] =  String.valueOf(secretWord.charAt(i));
                                isKnown = true;
                                updateKnownSoFar(process);

                         }
                    usedLetters.append( letter.charAt(0) );

                }
        }
        else {
            if (!getAllLetters().contains(letter))
            {   //indicate if the letter is not valid (-1),
                numberOfOccurences = -1;
            }
            else {
                // if the letter was already used (-2)
                numberOfOccurences = -2;
            }
            isKnown = true;
        }


        if(!isKnown) {
            numberOfIncorrectTries ++;
        }


        if (isGameOver()) {
            // indicate if game over
            numberOfOccurences = -3;
        }
        return numberOfOccurences;
    }
    /**
     * This method chooses a word for the Hangman game.
     * One word from the words array or words.txt file is assigned as the secretWord.
     * In order to test reading the file, you should fix the pathname in readTextFile method
     * There is no return.
     */
    private void chooseSecretWord() {
        int a;
        // To
        if (readTextFile() == null) {
            //List of word will be written here.
            words = new String[]{"mountain", "computer", "phone", "apple", "birthday", "headphones", "elephant", "programmer", "pencil"};
        }


        //a word from the list will be chosen randomly with Math.random.
        a = (int) ( Math.random() * words.length );
        // Fixed: String and buffer is not fit
        secretWord.append(words[a]) ;
    }
    public String getAllLetters() {

        return allLetters.toString();
    }
    public String getUsedLetters() {

        return usedLetters.toString();
    }
    public int getNumOfIncorrectTries() {

        return numberOfIncorrectTries;
    }

    public int getMaxAllowedIncorrectTries() {
        return MAX_ALLOWED_INCORRECT_TRIES;

    }
    public String getKnownSoFar() {

        return knownSoFar.toString();
    }

    public boolean isGameOver() {

        if (getNumOfIncorrectTries() == getMaxAllowedIncorrectTries()){
            knownSoFar = secretWord;
            return true;
        }
       else if (knownSoFar.toString().equals(secretWord.toString())) {
           return true;
        }
        return false;
    }
    public boolean hasLost() {
        if (getNumberOfIncorrectTries() == getMaxAllowedIncorrectTries()) {
            return true;
        }
        return false;
    }
    public int getNumberOfIncorrectTries() {

        return numberOfIncorrectTries;
    }

    // My own addition methods to improve game
    /**
     * This method updates the process of the word
     * Does not return anything
     */
    public void updateKnownSoFar (String[] array) {
        StringBuffer stringBuffer = new StringBuffer();
        for ( String a : array) {
            stringBuffer.append(a);
        }
        knownSoFar = stringBuffer;


    }
    /**
     * This method updates the process of the word
     * In order to use this method you should change the pathname to where words.txt is exist
     * In words.txt file words should be separated with spaces Exp: "game ball"
     */
    public String[] readTextFile() {
        String data = null;
        try {
            // Please fix this to your file pathname
            File myObj = new File("/Users/kutaysenyigit/Desktop/CS102/Hangman/out/production/Hangman/words.txt"); // text files name;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            words = data.split(" "); // in txt file words should be separated with space
            return words;
        } catch (FileNotFoundException e) {
            return null;
        }
    }



}

