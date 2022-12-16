package com.dyw.leetcode.medium.hash;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * @author Devil
 * @since 2022-09-06-11:04
 */
@SuppressWarnings("all")
public class L49字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(new L49字母异位词分组().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * hash表
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();

        if (strs.length==0||strs==null){
            return lists;
        }
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            List<String> orDefault = map.getOrDefault(string, new ArrayList<>());
            orDefault.add(str);
            map.put(string,orDefault);
        }

        for (List<String> value : map.values()) {
            lists.add(value);
        }


        return lists;
    }
}
