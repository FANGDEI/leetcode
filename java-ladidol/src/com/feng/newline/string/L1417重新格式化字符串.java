package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1417重新格式化字符串
 * @author: Ladidol
 * @description: 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * @date: 2022/8/11 10:41
 * @version: 1.0
 */
public class L1417重新格式化字符串 {

    class Solution {
        public String reformat(String s) {
            //先取出来，对字母和数字进行计数。
            int numCount = 0;
            int charCount = 0;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    numCount++;
                } else {
                    charCount++;
                }
            }
            //判断是不是满足课格式化的条件。
            if (Math.abs(numCount - charCount) > 1) {
                return "";
            }
            if (numCount > charCount) {
                numCount = 0;//数字其实指针
                charCount = 1;//字母起始指针
            } else {
                numCount = 1;
                charCount = 0;
            }
            //重新装表。
            char[] res = new char[s.length()];
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    res[numCount] = c;
                    numCount += 2;
                } else {
                    res[charCount] = c;
                    charCount += 2;
                }
            }
            return new String(res);
        }
    }
}
