package com.feng.leetcode.offerII._03字符串;

import java.util.HashMap;
import java.util.Map;

public class 剑指OfferII016不含重复字符的最长子字符串 {


    //滑动窗口(朴素版)
    class Solution {
        /**
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int ans = 0;
            for (int right = 0, left = 0; right < chars.length; right++) {
                while (map.getOrDefault(chars[right], 0) == 1) {
                    map.put(chars[left], map.get(chars[left]) - 1);
                    left++;
                }
                map.put(chars[right], 1);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }


    //还有个查表法。https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/7399/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/




}
