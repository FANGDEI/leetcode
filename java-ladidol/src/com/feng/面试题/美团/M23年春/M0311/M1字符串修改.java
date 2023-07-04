package com.feng.面试题.美团.M23年春.M0311;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/15 21:20
 * @description: {}
 */
public class M1字符串修改 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                chars[i] = '*';//因为是非数字，所以这里用这个占位方便后面进行判断。
                ans++;
            }
        }
        System.out.println(ans);
    }
}
