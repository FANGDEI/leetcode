package com.feng.newline.hashtable;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1624两个相同字符之间的最长子字符串
 * @author: Ladidol
 * @description: 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * 子字符串 是字符串中的一个连续字符序列。
 * 示例 1：
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * @date: 2022/9/17 23:05
 * @version: 1.0
 */
public class L1624两个相同字符之间的最长子字符串 {

    // 哈希
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            // 为了记录最大距离，我们只需要首尾的距离就行了。
            int[] idx = new int[26];//记录每一个字母的最早出现位置。
            Arrays.fill(idx, 301);//默认在无穷远处有最小下标。


            int ans = -1;

            for (int i = 0; i < s.toCharArray().length; i++) {
                int cur = s.charAt(i) - 'a';
                idx[cur] = Math.min(idx[cur], i);//维护idx数组。
                ans = Math.max(ans, i - idx[cur] - 1);//不包括两个端点。
            }

            return ans;
        }
    }
}
