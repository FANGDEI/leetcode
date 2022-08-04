package com.dyw.leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Devil
 * @since 2022-08-02-9:17
 * <p>
 * DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。
 * <p>
 * 例如，"ACGAATTCCG"是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
 */
@SuppressWarnings("all")
public class L187重复的DNA序列 {
    public static void main(String[] args) {
        System.out.println(new L187重复的DNA序列().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    /**
     * 滑动窗口 + hash表
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();
        if (n==0||n<=10){
            return result;
        }
        int right = 0, left = 0;

        HashSet<String> strings = new HashSet<>();

        while (right<n){
            while (right-left+1<10){
                right++;
            }
            if (right<n){
                String substring = s.substring(left, right+1);
                if (strings.contains(substring)&&!result.contains(substring)){
                    result.add(substring);
                }else{
                    strings.add(substring);
                }
                left++;
            }
        }
        return result;
    }
}
