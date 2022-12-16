package com.jirafa.蓝桥杯.十一届;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long i = scanner.nextLong();
        StringBuilder stringBuilder = new StringBuilder();
        while (i>0){
            stringBuilder.append(i).append(" ");
            i/=2;
        }
        System.out.println(stringBuilder);
    }
}
