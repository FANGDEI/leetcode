package com.feng.newline.dp.sub_sequence;

/**
 * @author: ladidol
 * @date: 2022/10/2 20:36
 * @description: 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * 通过次数309,500提交次数493,465
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
         * word1[i-1]和word2[j-1]不相等：取最小的可能数dp[i][j]
         * * 插入一个字符 等价于word2删除一个
         * * 删除一个字符 就是删除后的状态+1
         * * 替换一个字符 就是不管最新的两个元素，直接被替换
         */
        public int minDistance(String word1, String word2) {

            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            //初始化
            dp[0][0] = 0;
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;//全是i次的删除操作
            }

            for (int j = 1; j <= word2.length(); j++) {
                dp[0][j] = j;//全是j次的插入操作
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];//就不需要操作。
                    }
                    else {
                        //三种可能：
                        dp[i][j] = Math.min(
                                dp[i - 1][j] + 1,//word1串新增一个字符
                                Math.min(
                                        dp[i][j - 1] + 1, //word2串删除一个字符
                                        dp[i - 1][j - 1] + 1//其中一个字符串替换一个字符
                                )
                        );
                    }
                }
            }

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}