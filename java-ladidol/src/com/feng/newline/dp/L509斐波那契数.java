package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L509斐波那契数
 * @author: Ladidol
 * @description: 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * @date: 2022/8/16 14:41
 * @version: 1.0
 */
public class L509斐波那契数 {
    //1. 第i个数的斐波那契数值是dp[i]
    //2. dp[i] = dp[i - 1] + dp[i - 2];
    //3. dp[0] = 0; dp[1] = 1;
    //4. dp[i]是依赖 dp[i - 1] 和 dp[i - 2]，那么遍历的顺序一定是从前到后遍历的
    //5. 当N为10的时候，dp数组应该是如下的数列： 0 1 1 2 3 5 8 13 21 34 55
    class Solution {
        public int fib(int n) {
            if (n < 1) return 0;//避免为空的时候。
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }


    //压缩空间版本dp
    class Solution2 {
        public int fib(int n) {
            if (n < 2) return n;
            int a = 0, b = 1, c = 0;
            for (int i = 1; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
