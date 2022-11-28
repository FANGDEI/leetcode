package com.jirafa.luogu.chuanZhi;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        a=Math.abs(a);
        a= b>=0?a:(-1)*a;
        System.out.println(a);
    }
}
