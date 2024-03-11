package com.feng.面试题.大华;

public class NarcissisticNumber {
    public static void main(String[] args) {
        int n = 10000; // 设置上限值

        for (int i = 1; i <= n; i++) {
            if (isNarcissisticNumber(i)) {
                System.out.println(i);
            }
        }
    }

    // 判断一个数是否为水仙花数
    private static boolean isNarcissisticNumber(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        if (num<100){
            return false;
        }

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == originalNum;
    }
}