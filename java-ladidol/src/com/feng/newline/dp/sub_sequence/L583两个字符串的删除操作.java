package com.feng.newline.dp.sub_sequence;

/**
 * @author: ladidol
 * @date: 2022/10/2 19:46
 * @description: 给定两个单词word1和word2，返回使得word1和word2相同所需的最小步数。
 * 每步可以删除任意一个字符串中的一个字符。
 * 示例 1：
 * <p>
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * <p>
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 500
 * word1和word2只包含小写英文字母
 */
public class L583两个字符串的删除操作 {


    //方法一：正面求解，通过删除元素个数判断。
    class Solution1 {
        /**
         * 参数：[word1, word2]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         * dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
         * 当word1[i - 1] 与 word2[j - 1]相同的时候 直接不需要删除。dp[i-1][j-1]
         * 当word1[i - 1] 与 word2[j - 1]不相同的时候 需要删除操作：①dp[i-1][j] + 1②dp[i-1][j-1] + 2③dp[i][j-1] + 1
         */
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            //需要初始化。由方程得知
            dp[0][0] = 0;
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i - 1][j - 1] + 2, dp[i][j - 1] + 1));
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }

    //方法二：通过判断最大公共子序列，来反面求解，就和1143题没有啥子区别了。
    class Solution {
        /**
         * 参数：[word1, word2]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         * dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
         */
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);//看一下和倒数第二位是不是相等的。主要就是这三个方向。
                }
            }
            return word1.length() + word2.length() - 2 * dp[dp.length - 1][dp[0].length - 1];
        }
    }


}