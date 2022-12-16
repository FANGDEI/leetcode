package com.dyw.leetcode.medium.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @author Devil
 * @since 2022-09-06-11:19
 */
@SuppressWarnings("all")
public class L438找到字符串中所有字母异位词 {
    public static void main(String[] args) {

    }

    /**
     * leetcode 官方解法  滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        //如果s字符串的长度小于p字符串 那么根本不可能构成异位词
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount,pCount)){
            ans.add(0);
        }

        //滑动窗口部分 因为前面已经判断来了 0-pLen 的部分 右边界从pLen开始
        for (int i = 0; i<sLen-pLen; ++i){
            //开始滑动
            --sCount[s.charAt(i)-'a'];
            ++sCount[s.charAt(i+ pLen)- 'a'];
            //比较
            if (Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
