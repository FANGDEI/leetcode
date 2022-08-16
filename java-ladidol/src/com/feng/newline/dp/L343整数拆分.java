package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L343整数拆分
 * @author: Ladidol
 * @description: 给定一个正整数n，将其拆分为 k 个 正整数 的和（k >= 2），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积。
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 * @date: 2022/8/16 18:33
 * @version: 1.0
 */
public class L343整数拆分 {
    class Solution {

        //1. 确定dp数组以及下标的含义：整数i的最大乘积dp[i];
        //2. 确定递推公式：dp[i] = max({dp[i], (i - j) * j, dp[i - j] * j});
        //值得注意的就是这里有两个参数i
        //3. dp数组如何初始化：dp[2] = 1;
        //4. 确定遍历顺序：从0开始遍历j
        //5. 举例推导dp数组：1,2,4,6,9...
        public int integerBreak(int n) {
            if (n <= 1) return n;
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {

                //比较查看数字i的最大乘积。用dp[i]来记录。
                for (int j = 1; j <= i - j; j++) {// 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                    //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，

                    // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                    //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
                    int tempMax = Math.max((i - j) * j, dp[i - j] * j);
                    dp[i] = Math.max(dp[i], tempMax);
                }
            }
            return dp[n];
        }
    }
}
