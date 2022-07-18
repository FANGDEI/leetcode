package com.feng.newline.hashtable;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L49字母异位词分组
 * @author: Ladidol
 * @description:
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @date: 2022/7/10 20:52
 * @version: 1.0
 */
public class L49字母异位词分组 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,ArrayList<String>> map = new HashMap<>();//作为哈希表的map
            for (String str : strs) {
                char[] c = str.toCharArray();//转化成数组好操作一下！ O(n)
                Arrays.sort(c);
                String s = String.valueOf(c);
                if (!map.containsKey(s)){//第一次遇到等价字符串就开一个数组.
                    map.put(s,new ArrayList<>());
                }
                map.get(s).add(str);//将字符串放进该去的链表中.
            }
            //public ArrayList(Collection<? extends E> c)
            return new ArrayList<>(map.values());
        }
    }
}
