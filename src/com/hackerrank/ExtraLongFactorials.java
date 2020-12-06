package com.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger bigInt = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            bigInt = bigInt.multiply(new BigInteger(Integer.toString(i)));
        }
        System.out.println(bigInt);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        extraLongFactorials(n);
        scanner.close();
    }
}
