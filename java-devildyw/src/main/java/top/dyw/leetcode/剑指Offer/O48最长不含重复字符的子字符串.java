package top.dyw.leetcode.剑指Offer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/03/16 20:48
 **/
@SuppressWarnings("all")
public class O48最长不含重复字符的子字符串 {

    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        //使用 set 集合维护一个不重复的窗口
        Set<Character> set = new HashSet<>();
        //窗口右移(r维护滑动窗口的右指针)
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            //不满足条件窗口右移
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            //更新 res
            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
