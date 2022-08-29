package com.feng.newline.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L96不同的二叉搜索树
 * @author: Ladidol
 * @description: 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * @date: 2022/8/16 21:22
 * @version: 1.0
 */
public class L96不同的二叉搜索树 {//这里的二叉搜索树，就是说中序遍历一定是递增的。
    //”你想一个dp问题一定不能光想，而是要用笔涂涂画画，先考虑只有一个结点，再考虑两个结点，三个结点，
    //就能发现其实三个结点的答案能由前两个结点的答案推出，自然而然就想到dp了“
    //就是先找规律，你会发现，这个是从左往右，节点依次当根节点。dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]

    public static void main(String[] args) {
//        System.out.println(new Solution().numTrees(4));
    }
    class Solution {
        //1. 确定dp数组以及下标的含义：i个数字可以组成多少个二叉搜索树。
        //2. 确定递推公式：dp[i] += dp[j - 1] * dp[i - j];当根节点是j时：j-1 为左子树节点数量，i-j 为以j为头结点右子树节点数量
        //3. dp数组如何初始化：dp[0] = 1
        //4. 确定遍历顺序：那么遍历i里面每一个数作为头结点的状态，用j来遍历。
        //5. 举例推导dp数组：1,1,2,5,14,42
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {//i个节点的全部情况。
                    dp[i] += dp[j-1] * dp[i-j];//当根节点是j时：j-1 为左子树节点数量，i-j 为以j为头结点右子树节点数量
                }
            }
            return dp[n];
        }
    }

}



//    class Solution {
//        private static final Map<Integer, Integer> ans;
//
//        static {//离谱的static笑死。
//            ans = new HashMap<>();
//            ans.put(0, 1);
//            ans.put(1, 1);
//            ans.put(2, 2);
//            ans.put(3, 5);
//        }
//
//        public int numTrees(int n) {
//            if (ans.containsKey(n)) return ans.get(n);
//
//            int mid = (n - 1) / 2, sum = 0;
//            for (int left = 0; left <= mid; left++) {
//                int right = n - 1 - left;
//                if (!ans.containsKey(right)) ans.put(right, numTrees(right));
//                sum += 2 * (ans.get(left) * ans.get(right));
//            }
//            if (n % 2 == 1) sum -= ans.get(n / 2) * ans.get(n / 2);
//            ans.put(n, sum);
//            return sum;
//        }
//    }


