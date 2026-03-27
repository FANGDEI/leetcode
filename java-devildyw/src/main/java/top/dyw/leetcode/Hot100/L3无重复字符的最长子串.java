package top.dyw.leetcode.Hot100;

import java.util.HashMap;

public class L3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();

        int result = 0;
        int left = 0;
        for (int right=0; right<s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right-left+1);
        }

        return result;
    }
}
