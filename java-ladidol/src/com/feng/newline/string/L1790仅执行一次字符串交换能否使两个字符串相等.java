package com.feng.newline.string;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/11 14:09
 * @description: 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 */
public class L1790仅执行一次字符串交换能否使两个字符串相等 {


//    //哈希 （已经结束了呜呜呜）
//    class Solution {
//        /**
//         * 参数：[s1, s2]
//         * 返回值：boolean
//         * 作者： ladidol
//         * 描述：通过简单的遍历的同时使用计数
//         */
//        public boolean areAlmostEqual(String s1, String s2) {
//
//            PriorityQueue<Character> queue1 = new PriorityQueue<>();
//            PriorityQueue<Character> queue2 = new PriorityQueue<>();
//
//            Set<Character> set1 = new HashSet<>();
//            Set<Character> set2 = new HashSet<>();
//
//
//            int n = s1.length();
//            char[] chars1 = s1.toCharArray();
//            char[] chars2 = s2.toCharArray();
//
//
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                if (set1.add(chars1[i])) queue1.offer(chars1[i]);
//                if (set2.add(chars2[i])) queue2.offer(chars2[i]);
//                if (chars1[i] != chars2[i]) {
//                    if (++count > 2) return false;
//                }
//            }
//
//            if (count == 1) return false;
//            if (count == 2 && set1.size() != set2.size()) return false;
//
//            count = 0;
//            for (int i = 0; i < set1.size(); i++) {
//                if (queue1.poll() != queue2.poll()) count++;
//            }
//            if (count>3) return false;
//            return true;
//
//
////            return count != 2 || set1.size() == set2.size();
//        }
//    }

    //双指针
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {

            int n = s1.length();
            int idx1 = -1, idx2 = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (idx1 == -1) idx1 = i;//第一个不同的地方。
                    if (idx2 == -1 && idx1 != i) idx2 = i;//第二个不同的地方。
                }
            }
            if (count == 0) return true;
            if (count == 2
                    && s1.charAt(idx1) == s2.charAt(idx2)
                    && s1.charAt(idx2) == s2.charAt(idx1)) {
                return true;
            }
            return false;
        }
    }


}