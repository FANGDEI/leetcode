package com.feng.newline.string;


import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/12/12.
 *
 * @author Xiaoqiang-Ladidol
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * 示例 1：
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * 输入：s = "aabcbaa"
 * 输出：17
 * 提示：
 * 1 <= s.length <= 500
 */
public class L1781所有子字符串美丽值之和 {

    class Solution {
        public int beautySum(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                //对于每一个起点，我们都重新开一个map
                Map<Character, Integer> map = new HashMap<>();
                for (int j = i; j < n; j++) {
                    //每一个新串都要开一个新min和max
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                    //每一个终点都表示一个子串
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        min = Math.min(min, entry.getValue());
                        max = Math.max(max, entry.getValue());
                    }
                    System.out.println("max - min = " + (max - min));
                    ans += max - min;
                }

            }
            return ans;
        }
    }
}
