package com.dyw.leetcode.TOP面试题;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-11-30-10:59
 */
@SuppressWarnings("all")
public class L3重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new L3重复字符的最长子串().lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * hashset + 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0, rk = -1; //rk是滑动窗口右指针

        char[] chars = s.toCharArray();
        //i就是滑动窗口的左指针
        for (int i = 0; i < chars.length; i++) {
            //左指针移动 移动的同时删除set中的元素
            if (i!=0){
                set.remove(chars[i-1]);
            }

            //扩容阶段 遇到set中没有的字符扩充滑动窗口直到出现重复元素
            while (rk+1<s.length()&&!set.contains(chars[rk+1])){
                set.add(chars[rk+1]);
                rk++;
            }
            //如果跳出循环说明发现了重复的字符 此时滑动窗口定型 计算更新不重复子串的最大长度

            //更新长度
            res = Math.max(res,rk-i+1);
        }
        return res;
    }
}
