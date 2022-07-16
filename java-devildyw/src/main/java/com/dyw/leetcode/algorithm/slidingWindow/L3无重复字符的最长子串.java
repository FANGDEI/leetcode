package com.dyw.leetcode.algorithm.slidingWindow;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-07-16-10:32
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
@SuppressWarnings("all")
public class L3无重复字符的最长子串 {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口 因为需要判断重复字符 所以这里使用了HashSet
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //Hash集合 记录每个字符是否重复出现
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        //初始化滑动窗口的右个指针 rk 初始值为-1， 相当于我们在字符串的左边界的左侧 还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            //当右指针遇到了相同的元素时 右指针便不会移动了 直到左指针移动到直至没有重复的元素为止。(移动会剔除元素) 之后右指针又会继续右移扩张窗口 每次for循环在最后都会更新长度。
            if (i != 0) {
                //如果左指针不为0 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                //滑动窗口 不断移动右指针 直到下一个字符是重复的字符
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            //更新长度
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
