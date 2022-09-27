package com.feng.newline.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L面试题01_02判定是否互为字符重排
 * @author: Ladidol
 * @description: 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @date: 2022/9/27 13:44
 * @version: 1.0
 */
public class L面试题01_02判定是否互为字符重排 {
    // 一样望过去就是哈希。
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            for (char c : chars1) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : chars2) {
                if (!map.containsKey(c) || map.get(c) <= 0) return false;
                map.put(c, map.get(c) - 1);
            }
            return true;
        }
    }
}
