package com.hackerrank;

import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        System.out.println(getNextLexicographicString("ab"));
        System.out.println(getNextLexicographicString("bb"));
        System.out.println(getNextLexicographicString("hefg"));
        System.out.println(getNextLexicographicString("dhck"));
        System.out.println(getNextLexicographicString("dkhc"));
        System.out.println(getNextLexicographicString("abcd"));
        System.out.println(getNextLexicographicString("dcba"));
    }

    private static String getNextLexicographicString(String input) {
        for (int i = input.length() - 2; i >= 0; i--) {
            for (int j = input.length() - 1; j > i; j--) {
                if (input.charAt(j) > input.charAt(i)) {
                    input = swapStringIndices(input, i, j);
                    char[] trailing = input.substring(i + 1).toCharArray();
                    Arrays.sort(trailing);
                    return input.substring(0, i + 1) + new String(trailing);
                }
            }
        }
        return "no answer";
    }

    private static String swapStringIndices(String input, int i, int j) {
        char[] chars = input.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
