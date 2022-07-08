package com.dyw.leetcode.simple.string;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-07-05-12:08
 *
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 *
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 *
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 */
@SuppressWarnings("all")
public class L819最常见的单词 {
    public static void main(String[] args) {
        System.out.println(new L819最常见的单词().mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        char[] chars = new char[paragraph.length()];
        int index = 0;
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)|| c ==' '){
                chars[index++] = c;
            }else if (paragraph.charAt(i)==','){
                chars[index++] = ' ';
            }
        }
        String str = new String(chars, 0, index);
        String[] s1 = str.split("[ ]+");
        for (String s : s1) {
            map.put(s,map.getOrDefault(s,0)+1);
        }

        HashSet<String> strings = new HashSet<>();
        for (String s : banned) {
            strings.add(s);
        }

        String maxStr = null;
        int maxCount = -1;
        Collection<String> strings1 = map.keySet();
        for (String s : strings1) {
            System.out.println(s+":"+map.get(s));
            if (!strings.contains(s)&&(map.get(s)>maxCount)&&!s.equals(" ")){
                maxStr = s;
                maxCount = map.get(s);
            }
        }

        return maxStr;
    }
}
