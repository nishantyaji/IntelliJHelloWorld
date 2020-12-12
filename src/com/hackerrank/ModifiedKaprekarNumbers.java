package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ModifiedKaprekarNumbers {

    private static long splitAndAdd(long squaredNumber) {
        int numDigits = (int) (Math.log10(squaredNumber)) + 1;
        int part2NumDigits = (int) (numDigits+1)/2;
        long base = (long) Math.pow(10, part2NumDigits);
        return (squaredNumber%base) + (int) (squaredNumber/base);
    }

    // Complete the kaprekarNumbers function below.
    private static void kaprekarNumbers(int p, int q) {
        List<Long> result = new ArrayList<>();
        for(long i = p; i <= q; i++) {
            long square = i*i;
            if(i == splitAndAdd(square)) {
                result.add(i);
            }
        }
        if(result.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            result.forEach(l -> System.out.print(l +" "));
        }
    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }

}
