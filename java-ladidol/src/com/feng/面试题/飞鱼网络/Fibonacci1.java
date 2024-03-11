package com.feng.面试题.飞鱼网络;

public class Fibonacci1 {
    public static int calculateCows(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            String s = "stat";
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++) {  
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 6; // 输入年份
        int totalCows = calculateCows(n);
        System.out.println("牛的数量为：" + totalCows);
    }
}