package com.tydic.util;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Date() + "----------------start");
        int[] testArray = new int[10000];
        int[] combArray = new int[10000];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = 1;
        }
        int sum = 0;
        for (int m = 0; m < combArray.length; m++) {
            sum = testArray[m] * 2 + sum;
            combArray[m] = sum;
        }
        for (int j = 0; j < combArray.length; j++) {
            System.out.println(combArray[j]);
        }

        System.out.println(new Date() + "----------------end");
    }

}
