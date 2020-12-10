package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class JimAndTheJokes {

    public static void main(String[] args) {
        int[][] input = {
                {12, 31},
                {12, 31},
                {12, 31},
                {12, 31},
                {12, 31},
                {12, 31}
        };
        System.out.println(solve(input));
    }

    // Complete the solve function below.
    private static int solve(int[][] dates) {
        Map<Integer, Integer> jokes = new HashMap<>();
        for (int i = 0; i < dates.length; i++) {
            int value = valueFn(dates[i][0], dates[i][1]);
            if (value > -1) {
                if (jokes.containsKey(value)) {
                    int count = jokes.get(value);
                    jokes.put(value, count + 1);
                } else {
                    jokes.put(value, 1);
                }
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : jokes.entrySet()) {
            int entryValue = entry.getValue();
            result += (entryValue * (entryValue - 1)) / 2;
        }
        return result;
    }

    private static int valueFn(int month, int day) {
        if (month <= 1) {
            return -1;
        }
        int value = 0;
        String dayString = Integer.toString(day);
        char[] dayChars = dayString.toCharArray();
        for (char c : dayChars) {
            char[] charArray = {c};
            int cInt = Integer.parseInt(new String(charArray));
            if (cInt > month) {
                return -1;
            }
            value = value * month + cInt;
        }
        System.out.println(value);
        return value;
    }
}
