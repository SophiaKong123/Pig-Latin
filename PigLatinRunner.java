// Sophia Kong Pig Latin Runner
// (c) A+ Computer Science
// www.apluscompsci.com

// Scanner example four

import java.util.Scanner;
import static java.lang.System.*;
import java.io.IOException;
import java.io.File;

public class PigLatinRunner {
    
    public static void main(String args[]) throws IOException {
        
        String word = "";          // Stores a single word
        String pigWord = "";       // Holds the Pig Latin version of the current word
        String sentence = "";      // Stores the input sentence
        String pigSentence = "";   // Stores the full translated Pig Latin sentence

        PigLatin pigLatin = new PigLatin();

        // Create a Scanner object to read input from a file
        Scanner file = new Scanner(new File("PigLatinTestData.txt"));

        // Loop through the file to read each line (sentence)
        while (file.hasNext()) {
            sentence = file.nextLine(); // Read the next line from the file
            System.out.println(sentence); // Print the original sentence to the console
        }

        // Close the file Scanner after reading all data
        file.close();

        // Create a Scanner object to split the sentence into individual words
        Scanner chopper = new Scanner(sentence);

        // Loop to process each word from the sentence
        while (chopper.hasNext()) {
            word = chopper.next();                 // Take the next word from the sentence
            pigWord = pigLatin.translate(word);    // Translate the word to Pig Latin
            pigSentence += " " + pigWord;          // Add the translated word to the result string
        }

        // Print a blank line for formatting
        System.out.println(" ");

        // Print out the final Pig Latin version of the sentence
        System.out.println("Pig Sentence: " + pigSentence);
    }
}
