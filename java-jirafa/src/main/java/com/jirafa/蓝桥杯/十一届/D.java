package com.jirafa.蓝桥杯.十一届;

public class D {
    public static void main(String[] args) {
        int a=0;
        for (int i = 0; i < 2; i++) {
            a+=4;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 6; k++) {
                    a+=5;
                }
                a+=7;
            }
            a+=8;
        }
        a+=9;
        System.out.println(a);
    }
}
