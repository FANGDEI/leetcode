package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-06-12-13:41
 *
 *
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出words 中的 最短补全词 。
 *
 * 补全词 是一个包含 licensePlate 中所有字母的单词。忽略licensePlate 中的 数字和空格 。不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 *
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 *
 * 请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
 *
 */
@SuppressWarnings("all")
public class L748最短补全词 {
    public static void main(String[] args) {
        System.out.println(new L748最短补全词().shortestCompletingWord01(new String("1s3 456"), new String[]{"born", "give", "would", "nice", "in", "understand", "blue", "force", "have", "that"}));
    }

    /**
     * 本方法
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //初始化结果
        String res = null;
        //按照单词长度对数组进行排序
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        //将目标字符串全部转化为小写
        licensePlate = licensePlate.toLowerCase();
        //初始化map用于存储单词出现的次数
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isAlphabetic(c)) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        //遍历单词数组
        for (String word : words) {
            //进行比较 找到第一个满足要求的单词
            if (completingWord(word, charMap)) {
                res = word;
                break;
            }
        }

        return res;
    }

    /**
     * 判断单词是否符合要求
     */
    private Boolean completingWord(String word, HashMap<Character, Integer> charMap) {
        Set<Character> charSet = charMap.keySet();

        Iterator<Character> iterator = charSet.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (charMap.get(next) > charCounter(word, next)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单词计数器
     */
    private Integer charCounter(String word, Character next) {
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == next) {
                num++;
            }
        }
        return num;
    }

    /**
     * leetcode官方方法 借用数组下标对应26个英语字母充当map
     */
    public String shortestCompletingWord01(String licensePlate, String[] words) {
        //初始化 为存储26个单词出现次数的数组
        int[] cnt = new int[26];

        //将目标字符串全部字母转化为雄安锡额
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            //如果是字母就将其字母对应的字母表的位次在cnt数组中加一 表示它出现的次数加一
            if (Character.isLetter(c)) {
                cnt[c - 'a']++;
            }
        }

        //初始化结果字符串下标
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            //同上 初始化 为存储26个单词出现次数的数组
            int[] c = new int[26];
            for (int k = 0; k < words[i].length(); k++) {
                char ch = words[i].charAt(k);
                //同上
                c[ch - 'a']++;
            }

            //初始化flag
            boolean flag = true;
            //遍历两个数组 对比单词出现次数
            for (int j = 0; j < 26; j++) {
                if (c[j] < cnt[j]) {
                    //如果word中的出现次数小于licensePlate中的单词的出现次数 将flag设置为false
                    flag = false;
                    break;
                }
            }

            //如果flag为true且 index<0(即现在的index没有指定任何一个单词 此时初始化) 或者words[i]的长度小于index下标指定的单词的长度 那么更新index为i
            if (flag && (index < 0 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        //返回结果集
        return words[index];
    }
}
