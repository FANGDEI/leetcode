package com.feng.面试题.飞鱼网络;

public class Fibonacci {
    public static int calculateCows(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        
        return calculateCows(n - 1) + calculateCows(n - 3);
    }
    
    public static void main(String[] args) {
        int n = 7; // 输入年份
        int totalCows = calculateCows(n);
        System.out.println("牛的数量为：" + totalCows);
    }
}