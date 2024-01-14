package com.feng.面试题.全知科技;


import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/19 10:56
 * @description: {}
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        StringBuilder sb = new StringBuilder(s);

        int post = 0;
        while (post < n && Character.getNumericValue(s.charAt(post)) >= k) {
            post++;
        }
        sb.insert(post, k);
        System.out.println(sb.toString());

    }

}

