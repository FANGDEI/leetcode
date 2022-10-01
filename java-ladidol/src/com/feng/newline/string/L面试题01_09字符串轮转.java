package com.feng.newline.string;

import java.util.HashMap;

/**
 * @author: ladidol
 * @date: 2022/9/29 16:50
 * @description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>
 * 示例1:
 * <p>
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * 提示：
 * <p>
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * <p>
 * 你能只调用一次检查子串的方法吗？
 * <p> 每日一题：2022年9月29日16:52:51
 */
public class L面试题01_09字符串轮转 {
    // 移动窗口+哈希（类比187重复DNA序列）
    class Solution1 {
        /**
         * 参数：[s1, s2]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：很显然，这种类似循环数组的问题，可以直接转化成两倍数组长度.
         */
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            if (s1.equals("")) return true;//对于都是空字符串，直接返回true；
            s1 = s1 + s1;
            int n = s2.length();
            for (int i = 0; i <= s1.length() - n; i++) {
                String sub = s1.substring(i, i + n);
                if (s2.equals(sub)) {
                    return true;
                }
            }

            return false;
        }
    }

    // 移动窗口+哈希（类比187重复DNA序列）
    class Solution {
        /**
         * 参数：[s1, s2]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：很显然，这种类似循环数组的问题，可以直接转化成两倍数组长度.
         */
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            if (s1.equals("")) return true;//对于都是空字符串，直接返回true；
            s1 = s1 + s1;
            return s1.contains(s2);
        }
    }


    // 字符串哈希。
    class Solution2 {
        public boolean isFlipedString(String s1, String s2) {
            return true;
        }
    }
}