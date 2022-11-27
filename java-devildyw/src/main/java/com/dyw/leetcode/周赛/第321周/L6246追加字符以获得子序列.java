package com.dyw.leetcode.周赛.第321周;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-11-27-10:52
 */
@SuppressWarnings("all")
public class L6246追加字符以获得子序列 {
    public static void main(String[] args) {
        System.out.println(new L6246追加字符以获得子序列().appendCharacters("a", "juh"));
    }
    /**
     * 将t中s没有的字符按相对顺序添加在s字符串后面
     *
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public int appendCharacters(String s, String t) {
        //cnt 字符串 t 的指针 用于保证相对顺序
        int cnt = 0, n = t.length();
        for (int i = 0; i < s.length(); i++) {
            //如果s[i] 与 t[cnt] 相等就更新 cnt
            if (s.charAt(i)==t.charAt(cnt)){
                cnt++;
            }

            //优化用的 提前结束
            if (cnt==n){
                break;
            }
        }
        //最后返回 n-cnt就是要添加在s末尾的字符串长度
        return n-cnt;


    }
}
