package com.feng.newline.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L438找到字符串中所有字母异位词
 * @author: Ladidol
 * @description: 用滑动窗口来解题.
 * @date: 2022/7/10 21:11
 * @version: 1.0
 */
public class L438找到字符串中所有字母异位词 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] need = new int[26];//用于存p中需要的没中国魂字母数.
            for (char c : p.toCharArray()) {
                need[c - 'a']++;
            }
            int start = 0, end = 0;
            int[] window = new int[26];//表示窗口中的数据
            List<Integer> result = new ArrayList<>();
            while (end < s.length()) {
                window[s.charAt(end) - 'a']++;//更新窗口数据
                if (end - start + 1 == p.length()){//维护一个p.length()长度的窗口,并更新答案,并更新窗口中的数据.
                    if (Arrays.equals(window,need)){
                        result.add(start);
                    }
                    window[s.charAt(start)-'a']--;
                    start ++;//收缩窗口
                }
                end++;
            }
            return result;
        }
    }


}
