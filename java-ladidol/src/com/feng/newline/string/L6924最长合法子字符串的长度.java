package com.feng.newline.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L6924最长合法子字符串的长度 {


    //判断每一个结尾的字符串，最大合法字符串的长度。
    class Solution {
        /**
         * 值得注意的是：i的下标表示当前遍历的子穿左起点，初始从i = right - 1开始！！！！
         * @param word
         * @param forbidden
         * @return
         */
        public int longestValidSubstring(String word, List<String> forbidden) {
            Set<String> set = new HashSet<>();
            set.addAll(forbidden);
            int left = 0, ans = 0;
            for (int right = 0; right < word.length(); right++) {
                //超过10个长度的子串都不会存在forbidden中
                for (int i = right; i >= left && i > right - 10; i--) {//从right开始向前面遍历子串（以right结尾的子串）。
                    if (set.contains(word.substring(i, right + 1))) {
                        left = i + 1;
                        break;
                    }
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }


}
