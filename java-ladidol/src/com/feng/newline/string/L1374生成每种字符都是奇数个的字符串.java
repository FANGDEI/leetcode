package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1374生成每种字符都是奇数个的字符串
 * @author: Ladidol
 * @description:
 * 输入：n = 4
 * 输出："pppz"
 * 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
 * @date: 2022/8/2 13:12 昨天的每日一题
 * @version: 1.0
 */
public class L1374生成每种字符都是奇数个的字符串 {


    class Solution {
        //我们贪心的构造一个长度为n的全"a"字符串，奇数则直接返回，偶数则删除一个字符添加一个"b"即可
        public String generateTheString(int n) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append('a');
            }
            if (n%2==0){
                str.deleteCharAt(0).append('b');
            }
            return str.toString();
        }
    }
}
