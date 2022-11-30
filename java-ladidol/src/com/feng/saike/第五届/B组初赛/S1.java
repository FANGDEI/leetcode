package com.feng.saike.第五届.B组初赛;

import java.util.Scanner;

/**
 * @author: ladidol
 * @date: 2022/11/26 15:37
 * @description:
 */
public class S1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextInt();
        long b = scan.nextInt();
        a = Math.abs(a);
        System.out.println(b > 0 ? a : -a);
    }
}