package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-27-23:32
 * <p>
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 */
@SuppressWarnings("all")
public class L409最长回文串 {
    public static void main(String[] args) {
        System.out.println(new L409最长回文串().longestPalindrome("aaa"));
    }

    /**
     * 思路: 通过给出的字符构建一个最长的回文子串 就是找到出现次数为偶数的字符 将其所有出现都添加如我们要创建的回文串中
     * 然后找到出现次数为奇数的字符串 如果数量大于2 就将偶数的部分加入回文串 多出的哪一个字符 如果没有其他出现次数为奇数的字符 就放到回文串中央
     * 否者就随机从两者中选一个
     *
     * 简化:  找到出现次数为奇数的字符的个数
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        //创建大小为128的数组 对应128个ascii码
        int[] ascii = new int[128];

        for (int i = 0; i < s.length(); i++) {
            ascii[s.charAt(i)]++;
        }

        int count = 0;
        for (int i : ascii) {
            //找出出现次数为奇数的格式
            count+=i%2;
        }

        return count==0?s.length():(s.length()-count+1);
    }
}
