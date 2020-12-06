package com.hackerrank;

import java.util.*;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        //System.out.println(nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4)));
        System.out.println(nonDivisibleSubset(4, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    public static class MyPair {
        public int remainder;
        public int count;

        MyPair(int remainder, int count) {
            this.remainder = remainder;
            this.count = count;
        }

        public void increment() {
            this.count = this.count + 1;
        }
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        Set<Integer> permissibleRemainders = new HashSet<>();
        List<MyPair> myPairs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            permissibleRemainders.add(i);
            myPairs.add(new MyPair(i, 0));
        }
        for (Integer i : s) {
            int remainder = i % k;
            myPairs.get(remainder).increment();
        }
        if (myPairs.get(0).count > 1) {
            myPairs.get(0).count = 1;
        }
        if(k%2 == 0 && myPairs.get(k/2).count > 1) {
            myPairs.get(k/2).count = 1;
        }
        myPairs.sort((o1, o2) -> o2.count - o1.count);
        int setCount = 0;
        for (MyPair pair : myPairs) {
            if (permissibleRemainders.isEmpty()) {
                break;
            }
            boolean canConsider = permissibleRemainders.contains(pair.remainder);
            if (canConsider) {
                setCount += pair.count;
                permissibleRemainders.remove(k - pair.remainder);
            }
        }
        return setCount;
    }
}
