package com.feng.review.动态规划.子串;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/2 20:36 2023年2月24日新希望六和面试
 * @description: 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class L72编辑距离 {


    class Solution {

        /**
         * 参数：[word1, word2]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         * dp[i][j]：表示以word1[i-1]和word2[j-1]结尾的字母转换需要的最少操作数。
         * <p>
         * word1[i-1]和word2[j-1]相等：不变
         * word1[i-1]和word2[j-1]不相等：去最小的可能数dp[i][j]就有三种可能
         * 总结：
         * * (1)当前值相等就不变
         * * (2)删除一个字符 就是删除后的状态+1
         * * (3)插入一个字符 等价于word2删除一个
         * * (4)替换一个字符 就是不管最新的两个元素，直接被替换
         */
        public int minDistance(String word1, String word2) {

            //列是word1，行是word2；
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            //先初始化一下dp，看一下其中一个串是空传转化成另一个串的最少编辑距离
            for (int i = 1; i < word1.length() + 1; i++) {
                dp[i][0] = dp[i - 1][0] + 1;
            }
            for (int j = 1; j < word2.length() + 1; j++) {
                dp[0][j] = dp[0][j - 1] + 1;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        //不需要操作，就等于以前的。
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);//删除
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);//修改
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}