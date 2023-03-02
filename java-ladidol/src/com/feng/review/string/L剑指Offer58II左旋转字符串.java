package com.feng.review.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L剑指Offer58II左旋转字符串
 * @author: Ladidol
 * @description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 * 提示：
 * 具体步骤为：
 * <p>
 * 反转区间为前n的子串
 * 反转区间为n到末尾的子串
 * 反转整个字符串
 * @date: 2022/7/26 18:18
 * @version: 1.0
 */
public class L剑指Offer58II左旋转字符串 {
    class Solution1 {
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder sb = new StringBuilder(s);
            //反转n前面的子串
            reverseString(sb, 0, n - 1);
            //反转n后面的子串
            reverseString(sb, n, len - 1);
            return sb.reverse().toString();
        }

        public void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char tmp = sb.charAt(start);
                sb.setCharAt(start++, sb.charAt(end));
                sb.setCharAt(end--, tmp);//一定不要忘记移动双指针。
            }
        }
    }


    class Solution {
        /**
         * 通过双倍数组的思想来进行取模添加。
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            int len = s.length();
            StringBuilder ans = new StringBuilder();
            for (int i = n; i < len + n; i++) {
                ans.append(s.charAt(i % len));
            }
            return ans.toString();
        }
    }


}
