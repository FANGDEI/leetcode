package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1422分割字符串的最大得分
 * @author: Ladidol
 * @description: 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * 示例 1：
 * <p>
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 * @date: 2022/8/14 16:46 每日一题
 * @version: 1.0
 */
public class L1422分割字符串的最大得分 {

    public static void main(String[] args) {
//        System.out.println(new Solution().maxScore("011101"));
    }

    //模拟
    class Solution {
        public int maxScore(String s) {//之前把charAt（）和indexOf弄混了
            int max = 0;
            int _1Count = 0;//对1进行计数。
            int _0Count = 0;//对0进行计数。
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {//计数全部1
                if (chars[i] == '1') _1Count++;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (chars[i] == '0') {
                    _0Count++;
                } else {
                    _1Count--;
                }
                //你会发现max只会在0-1之间分割递增到s.length()-2 - s.length-1之间
                //说人话就是，避免了空子字符串的情况。
                max = Math.max(max, _0Count + _1Count);
            }
            return max;
        }
    }



    //前缀和+后缀和
    class Solution2 {
        public int maxScore(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int[] leftZero = new int[n];
            //记录0的个数
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    leftZero[i] = chars[i] == '0' ? 1 : 0;
                } else {
                    leftZero[i] = chars[i] == '0' ? leftZero[i - 1] + 1 : leftZero[i - 1];
                }
            }
            int[] rightOne = new int[n];
            //记录1的个数
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    rightOne[i] = chars[i] == '1' ? 1 : 0;
                } else {
                    rightOne[i] = chars[i] == '1' ? rightOne[i + 1] + 1 : rightOne[i + 1];
                }
            }
            //累加
            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                int cur = leftZero[i] + rightOne[i + 1];
                max = Math.max(cur, max);
            }
            return max;
        }
    }

}

