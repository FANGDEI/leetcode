package com.dyw.leetcode.algorithm.binarySearch;

/**
 * @author Devil
 * @since 2022-08-28-11:35
 *
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 */
@SuppressWarnings("all")
public class L69x的平方根 {
    public static void main(String[] args) {
        System.out.println(new L69x的平方根().mySqrt(4));
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        int ans = -1;
        while (left<right){
            int mid = left+(right-left)/2;
            //通过<=去无限趋近 我们的x目标值
            if ((long)mid*mid<=x){ //防止溢出
                ans = mid;
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return ans;
    }
}
