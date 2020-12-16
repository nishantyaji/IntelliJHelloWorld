package com.hackerrank;

import java.util.Hashtable;

public class IceCreamParlour {
    public static void main(String[] args) {
        whatFlavors(new int[]{4, 3, 2, 5, 7}, 8);
    }

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Hashtable<Integer, Integer> allElements = new Hashtable<>();
        for (int i1 : cost) {
            if (allElements.containsKey(i1)) {
                int count = allElements.get(i1);
                allElements.put(i1, count + 1);
            } else {
                allElements.put(i1, 1);
            }
        }
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < cost.length; i++) {
            if (allElements.containsKey(money - cost[i])) {
                if (money - cost[i] != cost[i]) {
                    firstIndex = i + 1;
                    break;
                } else {
                    if (allElements.get(cost[i]) > 1) {
                        firstIndex = i + 1;
                        break;
                    }
                }
            }
        }
        for (int j = firstIndex; j < cost.length; j++) {
            if (cost[j] == money - cost[firstIndex - 1]) {
                secondIndex = j + 1;
                break;
            }
        }
        System.out.println(firstIndex + " " + secondIndex);
    }
}
