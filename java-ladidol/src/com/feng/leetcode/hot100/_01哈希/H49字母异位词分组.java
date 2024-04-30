package com.feng.leetcode.hot100._01哈希;

import java.util.*;

public class H49字母异位词分组 {


    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);//排序
                List<String> stringList = map.computeIfAbsent(new String(chars), para -> new ArrayList<>());
                stringList.add(str);
            }
            return new ArrayList<>(map.values());
        }
    }


}
