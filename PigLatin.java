 // Sophia Kong Pig Latin
 public class PigLatin {

    // Instance variables for input word and translated word.
    String pigWord = "";
    String word = "";

    PigLatin() { }

    //Translates an entire string into Pig Latin. Handles words, punctuation, and special characters.
    public String translate(String str) {
        pigWord = "";   // Clears the Pig Latin result for the new translation.
        word = "";      // Resets the current word buffer.
    
        // Goes through each index.
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
    
            if (Character.isLetter(c) || c == '\'') { // Check if the character is a letter or an apostrophe.
                word += c; // Add the character to the string.
            } else {
                // When encountering a non-letter character, translate the current word.
                if (!word.isEmpty()) {
                    pigWord += translateWord(word); // Translate the string to Pig Latin.
                    word = ""; // Reset the string.
                }
                // Add non-letter characters (including punctuation) directly to the result.
                pigWord += c; 
            }
        }
    
        // Handle the last word in the string if it's not followed by punctuation.
        if (!word.isEmpty()) {
            pigWord += translateWord(word);
        }
    
        return pigWord; // Return the Pig Latin string with punctuation preserved.
    }
    

    //  Translates a single word into Pig Latin. Handles capitalization, words starting with "qu," and consonant/vowel rules.
    public String translateWord(String word) {
        // Check if the word starts with an uppercase letter.
        boolean isCapital = Character.isUpperCase(word.charAt(0));
        word = word.toLowerCase(); // Convert the word to lowercase for processing.
    
        // Handle words that start with "qu".
        if (word.startsWith("qu")) {
            word = word.substring(2) + "quay"; // Move "qu" to the end and add "ay".
        } else {
            // Find the index of the first vowel in the word.
            int vowelIndex = findFirstVowelIndex(word);
    
            if (vowelIndex == 0) { // Word starts with a vowel.
                if (word.length() <= 3) {
                    word = word + "hay"; // Short vowel words get "hay" added.
                } else {
                    word = word + "way"; // Longer vowel words get "way" added.
                }
            } else if (vowelIndex > 0) { // Word starts with consonants or 'y' as a consonant.
                String consonantCluster = word.substring(0, vowelIndex);
                String restOfWord = word.substring(vowelIndex);
    
                // Check if the first and last letter are the same, and if so, only use one of them
                if (consonantCluster.length() == 1 && restOfWord.charAt(restOfWord.length() - 1) == consonantCluster.charAt(0)) {
                    restOfWord = restOfWord.substring(0, restOfWord.length() - 1); // Remove the extra matching letter at the end.
                }
    
                word = restOfWord + consonantCluster + "ay"; // Translate normally.
            } else { // No vowels found, treat as a consonant-only word.
                word = word + "ay";
            }
        }
    
        // Capitalize the first letter if the original word was capitalized.
        if (isCapital) {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }
    
        return word; // Return the translated Pig Latin word.
    }
    
    

    // Checks if a character is punctuation.
    private boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == '!' || c == '?' || c == ';' || c == ':';
    }

    //  Checks if a character is a vowel (a,e,i,o,u). 
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    //  Finds the index of the first vowel in a word. Also treats 'y' as a vowel if it is not the first character.
    private int findFirstVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i)) || (word.charAt(i) == 'y' && i > 0)) {
                // 'y' is treated as a vowel if it's not the first character.
                return i;
            }
        }
        return -1; // Return -1 if no vowels are found.
    }
}