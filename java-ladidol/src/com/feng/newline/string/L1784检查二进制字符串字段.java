package com.feng.newline.string;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/10/3 12:02
 * @description: 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * 如果 s中由连续若干个'1' 组成的字段数量不超过 1，返回 true 。否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 */
public class L1784检查二进制字符串字段 {


    //字符串模拟
    class Solution {
        /**
         * 参数：[s]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：
         * 该题题意有点难理解，没说很明白。
         * 就是含有1的模块数目小于等于1。
         */
        public boolean checkOnesSegment(String s) {
            char[] chars = s.toCharArray();

            char pre = ' ';
            int count = 0;


            for (int i = 0; i < s.length(); i++) {
                if (pre == '1' && pre == chars[i]) {
                    continue;
                }
                if (chars[i] == '1') {
                    if (count==1) return false;
                    count++;
                }
                pre = chars[i];
            }
            return true;
        }
    }
}