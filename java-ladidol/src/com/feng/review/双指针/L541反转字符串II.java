package com.feng.review.双指针;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L541反转字符串II
 * @author: Ladidol
 * @description:
 * @date: 2022/7/26 15:42 2023年3月2日14:55:14
 * @version: 1.0
 */
public class L541反转字符串II {
    class Solution {
        //因为要找的也就是每2 * k 区间的起点，这样写，程序会高效很多。
        //所以当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。

        /**
         * 类比反转字符串I中
         *
         * @param s
         * @param k
         * @return
         */
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i += 2 * k) {
                int left = i;
                int right = Math.min(n - 1, i + k - 1);
                while (left < right) {
                    char tmp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = tmp;
                }
            }
            return new String(chars);
        }
    }
}
