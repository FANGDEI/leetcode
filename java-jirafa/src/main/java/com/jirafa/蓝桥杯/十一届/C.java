package com.jirafa.蓝桥杯.十一届;

public class C {
    public static void main(String[] args) {
        int sum=Integer.MAX_VALUE;
        int min = 0;
        for (int i = 1; i < 100; i++) {
            if(sum>100/i+i){
                min=i;
                sum=100/i+i;
            }
        }
        System.out.println(min);
    }
}
