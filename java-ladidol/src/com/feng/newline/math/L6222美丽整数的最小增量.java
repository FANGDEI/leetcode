package com.feng.newline.math;

/**
 * @author: ladidol
 * @date: 2022/10/30 15:08
 * @description: 给你两个正整数 n 和 target 。
 * 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
 * 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
 * 示例 1：
 * <p>
 * 输入：n = 16, target = 6
 * 输出：4
 * 解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
 * 示例 2：
 * <p>
 * 输入：n = 467, target = 6
 * 输出：33
 * 解释：最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 + 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：0
 * 解释：最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
 * 提示：
 * <p>
 * 1 <= n <= 1012
 * 1 <= target <= 150
 * 生成的输入保证总可以使 n 变成一个美丽整数。
 */
public class L6222美丽整数的最小增量 {


    // 317周赛第三题
    class Solution {
        public long makeIntegerBeautiful(long n, int target) {

            if (check(n, target)) {
                return 0;
            }

            //一个一个找最近的10被整除最小上限；
            long base = 10;
            long cur = n % base;
            for (int i = 0; i < 15; i++) {
                long remain = base - cur;
                if (check(n + remain, target)) {
                    return remain;
                }
                base *= 10;
                cur = n % base;

            }
            return -1;
        }
        boolean check(long num, int t) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum <= t;
        }
    }



}