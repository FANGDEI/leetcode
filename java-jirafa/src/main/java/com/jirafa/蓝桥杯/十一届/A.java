package com.jirafa.蓝桥杯.十一届;

public class A {
    public static void main(String[] args) {
        int all=10000;
        int i=all/(300);
        int res;
        if(10000-(i-1)*300<600){
            res=(i-1)*2*60+(10000-(i-1)*300)/10;
        }else {
            res=i*2*60+10000-i*300/10;
        }
        System.out.println(res);
    }
}
