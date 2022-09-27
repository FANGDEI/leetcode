package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L451根据字符出现频率排序
 * @author: Ladidol
 * @description: 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * 示例 1:
 * <p>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * @date: 2022/9/1 12:16
 * @version: 1.0
 */
public class L451根据字符出现频率排序 {
    //用hash法，list排序。
    class Solution1 {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {// 放入map中去
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
            List<Character> list = new LinkedList<>(map.keySet());//得到map的keylist
            list.sort((a, b) -> {
                return map.get(b) - map.get(a);// 对list进行频率降序排序。
            });
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                for (int i = 0; i < map.get(c); i++) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    //数组模拟哈希，优先级队列排序
    class Solution2 {
        public String frequencySort(String s) {
            char[] cs = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : cs) map.put(c, map.getOrDefault(c, 0) + 1);
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
                return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
            });
            for (char c : map.keySet()) q.add(new int[]{c, map.get(c)});
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int c = poll[0], k = poll[1];
                while (k-- > 0) sb.append((char) (c));
            }
            return sb.toString();
        }
    }

    // 2022年9月27日15:21:37：再做这一题，说实话又是map的一些神奇操作。
    class Solution {
        //就是用map进行字母计数，然后再根据数目降序排序。
        public String frequencySort(String s) {
            TreeMap<Character, Integer> map = new TreeMap<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<Character> keyList = new LinkedList<>(map.keySet());
            Collections.sort(keyList, (o1, o2) -> map.get(o2) - map.get(o1));

            StringBuilder ans = new StringBuilder();
            for (Character key : keyList) {
                for (int i = 0; i < map.get(key); i++) {
                    ans.append(key);
                }
            }
            return ans.toString();
        }
    }


}
