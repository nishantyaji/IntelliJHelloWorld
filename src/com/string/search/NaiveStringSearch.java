package com.string.search;

public class NaiveStringSearch {
    public static void main(String[] args) {
        searchStr("23438123995345129392355", "12");
        searchStr("23438123995345129392355", "23");
    }

    public static void searchStr(String input, String pattern) {
        for (int i = 0; i < input.length(); i++) {
            int j = 0;
            for (j = 0; j < pattern.length(); j++) {
                if (input.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pattern.length()) {
                System.out.println("Pattern (" + pattern + ") found in input string at index: " + i);
            }
        }
    }
}
