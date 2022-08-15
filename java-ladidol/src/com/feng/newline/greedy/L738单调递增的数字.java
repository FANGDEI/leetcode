package com.feng.newline.greedy;


import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L738单调递增的数字
 * @author: Ladidol
 * @description: 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 示例 1:
 * <p>
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: n = 332
 * 输出: 299
 * @date: 2022/8/15 20:20
 * @version: 1.0
 */
public class L738单调递增的数字 {
    //贪心。
    class Solution {
        //本题只要想清楚个例，例如98，一旦出现strNum[i - 1] > strNum[i]的情况（非单调递增），
        // 首先想让strNum[i - 1]减一，strNum[i]赋值9，这样这个整数就是89。
        // 就可以很自然想到对应的贪心解法了。
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int startToNine = chars.length;
            //找到需要开始赋值9的位置。
            for (int i = chars.length - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    startToNine = i + 1;
                }
            }

            //开始赋值9
            for (int i = startToNine; i < chars.length; i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(java.lang.String.valueOf(chars));
        }
    }

    //欣赏一下别人的艺术吧。
    class Solution1 {
        public int monotoneIncreasingDigits(int N) {
            for (int i = N, j = 9, k = 1; i > 0; i /= 10, k *= 10)
                if (j < (j = i % 10))// 如果后一位比前一位小
                    // 以332为例，第1次走到这一步的时候 i=33,k=10, 329进入递归
                    // 第2次走到这一步的时候 i=3,k=100, 299进入递归
                    return monotoneIncreasingDigits(i * k - 1);
            // 299递归出口
            return N;
        }
    }

}
