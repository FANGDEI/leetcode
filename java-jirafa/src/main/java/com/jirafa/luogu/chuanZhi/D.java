package com.jirafa.luogu.chuanZhi;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }

        Arrays.sort(ints);
        int result=Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            result= Math.min(ints[Math.min(n - m + i-1, n - 1)] - ints[i], result);
        }
        if(m==0)
            result= ints[ints.length-1]-ints[0];

        System.out.println(result);
    }

}
