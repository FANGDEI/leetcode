package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L剑指Offer05替换空格
 * @author: Ladidol
 * @description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @date: 2022/7/26 17:00
 * @version: 1.0
 */
/*如果想把这道题目做到极致，就不要只用额外的辅助空间了！
首先扩充数组到每个空格替换成"%20"之后的大小。
然后从后向前替换空格，也就是双指针法，过程如下：
i指向新长度的末尾，j指向旧长度的末尾。*/
public class L剑指Offer05替换空格 {

    //用新字符串来装的来装。简单点！
    class Solution {
        public String replaceSpace(String s) {
            if (s == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
//双指针法.
//    class Solution2 {
//        //方式二：双指针法
//        public String replaceSpace(String s) {
//            if (s == null || s.length() == 0) {
//                return s;
//            }
//            //扩充空间，空格数量2倍
//            StringBuilder str = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == ' ') {
//                    str.append("  ");
//                }
//            }
//            //若是没有空格直接返回
//            if (str.length() == 0) {
//                return s;
//            }
//            //有空格情况 定义两个指针
//            int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
//            s += str.toString();
//            int right = s.length() - 1;//右指针：指向扩展字符串的最后一个位置
//            char[] chars = s.toCharArray();
//            while (left >= 0) {
//                if (chars[left] == ' ') {
//                    chars[right--] = '0';
//                    chars[right--] = '2';
//                    chars[right] = '%';
//                } else {
//                    chars[right] = chars[left];
//                }
//                left--;
//                right--;
//            }
//            return new String(chars);
//        }
//    }

}
