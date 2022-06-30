package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-30-12:34
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 */
@SuppressWarnings("all")
public class L520检测大写字母 {
    public static void main(String[] args) {

    }

    /**
     * 考虑:
     * 1. 如果第一个单词是大写 那么后续出现中存在大写又存在小写 返回false
     * 2. 如果开头是小写 那么后续只要出现了大写那么都返回false
     *
     * 现获取数组第一个数字 判断是否为
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char c = word.charAt(0);
        int n = word.length();
        //小写的情况
        if (Character.isLowerCase(c)){
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }//大写的情况
        else{
            boolean upper  = false, lower = false;
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))){
                    upper = true;
                }else {
                    lower = true;
                }
            }
            if (upper&&lower){
                return false;
            }else{
                return true;
            }
        }
    }

    /**
     * 改良版本
     * @param word
     * @return
     */
    public boolean detectCapitalUse01(String word) {
        //若第一个字母为小写,则需要额外判断第二个字母是否为小写
        if (word.length()>=2&&Character.isLowerCase(word.charAt(0))&&Character.isUpperCase(word.charAt(1))){
            return false;
        }
        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
}
