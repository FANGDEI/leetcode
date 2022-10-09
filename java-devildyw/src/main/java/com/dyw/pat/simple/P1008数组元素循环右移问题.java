package com.dyw.pat.simple;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-09-14:02
 */
@SuppressWarnings("all")
public class P1008数组元素循环右移问题 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        while (m-->0){
            int temp = array[n-1];
            for (int i = n-1; i >= 1; i--) {
                array[i] = array[i-1];
            }
            array[0] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i!=n-1){
                System.out.print(" ");
            }
        }
    }
}
