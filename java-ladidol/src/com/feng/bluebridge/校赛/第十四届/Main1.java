package com.feng.bluebridge.校赛.第十四届;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: ${DATE} ${TIME}
 * @description: {}
 */
public class Main1 {
    public static void main(String[] args) {
        //在闭区间 [1,20221217] 中，有多少个整数，满足其因数的个数为3？
        //请注意，本题为结果填空题，你只需要填写一个整数，不要带有包括空格在内的其他多余字符。
        //先进行判断，是不是完全平方数
        int ans = 0;
        System.out.println("Math.sqrt(20221217) = " + Math.sqrt(20221217));
        for (int i = 1; i <= Math.sqrt(20221217); i++) {
            if (i * i >= 20221217) break;
            ans++;
        }
//        System.out.println("ans = " + ans);
        //再判断有没有除了这三个以外的其他因数。
        int n = ans;
        for (int i = 1; i <= n; i++) {
            if (isPrim222(i)) {
                ans--;
            }
        }
        System.out.println("ans = " + ans);
//        Math.sqrt(20221217) = 4496.800751645552
//        ans = 610

//        System.out.println(isPrim222(1));
//        System.out.println(isPrim222(2));
//        System.out.println(isPrim222(3));
//        System.out.println(isPrim222(4));
//        System.out.println(isPrim222(5));
//        System.out.println(isPrim222(6));
//        System.out.println(isPrim222(7));

    }

    static boolean isPrim(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
    static boolean[] is = new boolean[1000005];
    static boolean isPrim222(int n){
        //倍筛法
        is[1] = true;//true表示不是素数
        for (int i = 2; i < 1000005; i++)
            if (!is[2])
                for (int j = 2 * i; j < 1000005; j += i)
                    is[j] = true;
        return is[n];

    }
}