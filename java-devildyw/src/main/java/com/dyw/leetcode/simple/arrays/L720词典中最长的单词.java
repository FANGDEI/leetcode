package com.dyw.leetcode.simple.arrays;


import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-06-09-14:32
 * <p>
 * 给出一个字符串数组words 组成的一本英语词典。返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 */
@SuppressWarnings("all")
public class L720词典中最长的单词 {

    public static void main(String[] args) {
        String[] strings = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        System.out.println(new L720词典中最长的单词().longestWord(strings));
    }

    /**
     * hash集合的方式
     *
     * @param words
     * @return longest
     */
    public String longestWord(String[] words) {
        //自定义排序函数 这个排序很关键  (若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。)
        Arrays.sort(words, (a, b) -> {
            //长度优先
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                //如果长度相同那么比较两者的字典序 以小的为标准
                return b.compareTo(a);
            }
        });

        //初始化一个结果字符串 即由前面子字符串组成的字符串
        String longest = "";

        //初始化一个集合
        HashSet<String> strings = new HashSet<>();
        strings.add("");
        int length = words.length;

        //遍历
        for (int i = 0; i < length; i++) {
            String word = words[i];
            //通过该条件不断更新集合中的元素 不断更新longest
            //如果集合存在该字符串0到size-1的子字符串那么set更新且longest等于word
            if (strings.contains(word.substring(0, word.length() - 1))) {
                strings.add(word);
                longest = word;
            }
        }
        return longest;
    }
}
