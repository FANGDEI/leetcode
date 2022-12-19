package com.jirafa.leetcode.algorithm.dp;

import org.junit.Test;

import java.util.ArrayList;

/**
 * link: https://leetcode.cn/problems/fibonacci-number/
 */
public class L509 {
    public int fib(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);
        for (int i = 2; i <= n; i++) {
            dp.add(dp.get(i-1)+dp.get(i-2));
        }
        System.out.println(dp);
        return dp.get(n);
    }

    //双变量版本
    public int fib2(int n){
        if (n < 2) return n;
        int a=0,b=1,sum = 0;
        for (int i = 2; i <= n; i++) {
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(new L509().fib2(4));
    }
}
