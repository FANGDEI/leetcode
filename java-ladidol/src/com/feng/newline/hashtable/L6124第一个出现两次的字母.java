package com.feng.newline.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L6124第一个出现两次的字母
 * @author: Ladidol
 * @description: 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * 注意：
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * @date: 2022/7/24 10:34
 * @version: 1.0
 */
public class L6124第一个出现两次的字母 {
    class Solution {
        Map<Character,Integer> map = new HashMap<>();
        public char repeatedCharacter(String s) {
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)){
                    return c;
                }
                map.put(c,1);
            }
            return '#';
        }
    }
}
