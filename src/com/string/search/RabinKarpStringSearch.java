package com.string.search;

public class RabinKarpStringSearch {
    // number of characters allowed in the universe
    public static final int MULTIPLIER = 256;
    public static final int PRIME_NUM = 137;

    public static void main(String[] args) {
        searchStr("23438123995345129392355", "12");
        searchStr("23438123995345129392355", "23");
    }

    public static void searchStr(String input, String pattern) {
        int inputLength = input.length();
        int patternLength = pattern.length();
        int i, j;
        int patternHash = 0; // hash value for pattern
        int textHash = 0; // hash value for txt
        int h = 1;

        // The value of h would be MULTIPLIER^(patternLength-1) mod PRIME_NUM
        for (i = 0; i < patternLength - 1; i++)
            h = (h * MULTIPLIER) % PRIME_NUM;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < patternLength; i++) {
            patternHash = (MULTIPLIER * patternHash + pattern.charAt(i)) % PRIME_NUM;
            textHash = (MULTIPLIER * textHash + input.charAt(i)) % PRIME_NUM;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= inputLength - patternLength; i++) {

            // Check the hash values of current window of text
            // If hash values match then only check for characters one by one
            if (patternHash == textHash) {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == patternLength) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < inputLength - patternLength) {
                textHash = (MULTIPLIER * (textHash - input.charAt(i) * h) + input.charAt(i + patternLength)) % PRIME_NUM;

                // We might get negative value of t, converting it
                // to positive
                if (textHash < 0)
                    textHash = (textHash + PRIME_NUM);
            }
        }
    }

}
