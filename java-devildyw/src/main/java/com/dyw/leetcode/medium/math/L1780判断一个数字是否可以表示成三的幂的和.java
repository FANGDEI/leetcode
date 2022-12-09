package com.dyw.leetcode.medium.math;

/**
 * @author Devil
 * @since 2022-12-09-17:16
 */
@SuppressWarnings("all")
public class L1780判断一个数字是否可以表示成三的幂的和 {

    public static void main(String[] args) {

    }

    /**
     * 我们可以将 nn 转换成 33 进制。如果 nn 的 33 进制表示中每一位均不为 22，那么答案为 \text{True}True，否则为 \text{False}False。
     *  12 = 3 + 3^2 12 = (110)3  21 = (210)3 不满足条件
     * @param n
     * @return
     */
    public boolean checkPowersOfThree(int n) {
        /**
         * 进制转换
         */
        while (n!=0){
            if (n%3==2){
                return false;
            }
            n /= 3;
        }
        return true;

    }
}
