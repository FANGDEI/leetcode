package com.feng.leetcode.week;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/30 20:55
 * @description: {}
 */

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s1 = in.nextLine().toCharArray();
        char[] s2 = in.nextLine().toCharArray();
        StringBuilder res = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (Character c : s2) {
            set.add(c);
        }
        for (int i = 0; i < s1.length; i++) {
            if (set.contains(s1[i])) continue;
            res.append(s1[i]);
        }
        System.out.print(res);
    }
}