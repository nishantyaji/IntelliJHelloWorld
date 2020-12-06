package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MaxArraySum {
    public static void main(String[] args) {
//        System.out.println(maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
        System.out.println(maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
    }

    private static Map<Integer, Integer> countMap = new HashMap<>();

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        countMap.put(0, arr[0]);
        countMap.put(1, arr[1] > arr[0] ? arr[1] : arr[0]);
        if (arr.length > 2) {
            int count3 = countMap.get(0) + arr[2];
            count3 = count3 > countMap.get(0) ? count3 : countMap.get(0);
            count3 = count3 > countMap.get(1) ? count3 : countMap.get(1);
            countMap.put(2, count3);
            for (int i = 3; i < arr.length; i++) {
                int max = countMap.get(i - 2);
                max = max > max + arr[i] ? max : max + arr[i];
                int maxBefore = countMap.get(i - 3);
                maxBefore = maxBefore > maxBefore + arr[i-1] ? maxBefore : maxBefore + arr[i-1];
                max = max > maxBefore ? max : maxBefore;
                countMap.put(i, max);
            }
        }
        return countMap.get(arr.length - 1);
    }

}
