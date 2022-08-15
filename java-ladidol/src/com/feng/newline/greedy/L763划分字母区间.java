package com.feng.newline.greedy;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L763划分字母区间
 * @author: Ladidol
 * @description: 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * @date: 2022/8/15 17:28
 * @version: 1.0
 */
public class L763划分字母区间 {
    class Solution {//听说这道题思路很巧妙emm，不像贪心。

        //就是用map来做。注意关注每个子串的最右边的字母。
        public List<Integer> partitionLabels(String s) {
            int[] hash = new int[26];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i) - 'a'] = i;//记录当前字母出现的最远位置。
            }
            int curRightEdge = 0;
            int curLeftEdge = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                curRightEdge = Math.max(curRightEdge, hash[s.charAt(i) - 'a']);//更新当前子串中字母的最远位置，即右边界。
                if (curRightEdge == i) {//走到这里来了
                    res.add(curRightEdge - curLeftEdge + 1);
                    curLeftEdge = i + 1;//更新左边界，为下一个子串做准备。
                }
            }
            return res;
        }
    }
}
