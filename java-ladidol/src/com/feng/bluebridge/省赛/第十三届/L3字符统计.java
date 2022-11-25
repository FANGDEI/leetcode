package com.feng.bluebridge.省赛.第十三届;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/19 12:48
 * @description: 【问题描述】
 * 给定一个只包含大写字母的字符串 S，请你输出其中出现次数最多的字母。
 * 如果有多个字母均出现了最多次，按字母表顺序依次输出所有这些字母。
 * 【输入格式】
 * 一个只包含大写字母的字符串 S .
 * 【输出格式】
 * 若干个大写字母，代表答案。
 * 【样例输入】
 * BABBACAC
 * 【样例输出】
 * AB
 */
public class L3字符统计 {
    /**
     * 作者：Ladidol
     * 描述：先维护每个字母出现的个数，并得到最大的次数。
     * 最后通过TreeSet字典序拍一下。
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > maxCount) maxCount = map.get(c);
        }
        Set<Character> set = new TreeSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                set.add(entry.getKey());
            }
        }
        for (Character c : set) {
            System.out.print(c);
        }


    }
}