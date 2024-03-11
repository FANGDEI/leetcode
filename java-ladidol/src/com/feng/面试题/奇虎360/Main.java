package com.feng.面试题.奇虎360;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/10/14 15:52
 * @description: {}
 */
public class Main {
    public static int crackNumber(int ciphertext) {
        String str = Integer.toString(ciphertext);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= str.length(); i++) {
            String x = str.substring(i - 2, i);
            if (x.compareTo("10") >= 0 && x.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[str.length()];
    }

    public static void main(String[] args) {
        int ciphertext = 114514;
        int result = crackNumber(ciphertext);
        System.out.println(result);
    }
}





















