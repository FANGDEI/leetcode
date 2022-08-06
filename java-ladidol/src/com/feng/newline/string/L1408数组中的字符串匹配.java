package com.feng.newline.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1408数组中的字符串匹配
 * @author: Ladidol
 * @description: 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * @date: 2022/8/6 14:14
 * @version: 1.0
 */
public class L1408数组中的字符串匹配 {

    class Solution1 {
        //穷举+调用api
        public List<String> stringMatching(String[] words) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (i != j && words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
            return res;
        }
    }

    //我们先把words中所有的单词拼成一个大的字符串，然后判断每个字符串是不是有两个位置，有两个位置则证明是存在某个单词是子字符串，加入答案，注意加“,”来隔开
    class Solution {
        //拼接成大字符串
        public List<String> stringMatching(String[] words) {
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder(words[0]).append(",");
            for (int i = 1; i < words.length; i++) {
                sb.append(words[i]).append(",");
            }
            for (int i = 0; i < words.length; i++) {
                if (sb.indexOf(words[i]) != sb.lastIndexOf(words[i])) {
                    res.add(words[i]);
                }
            }
            return res;
        }
    }
}
