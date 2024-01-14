package com.feng.面试题.腾讯云智秋招.一面;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/9 9:55
 * @description: {}
 *
 * 1）给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *         例如输入： s = “God Ding”，输出：“doG gniD”
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
        String s = scan.nextLine();
        String[] split = s.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            split[i] = check(split[i]);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i==0){
                ans.append(split[i]);
                continue;
            }
            ans.append(" "+split[i]);
        }
        System.out.println(ans);

    }
    public static String check(String s){
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();

        int n = chars.length;
        for (int i = n-1; i >=0 ; i--) {
            ans.append(chars[i]);
        }
        return ans.toString();
    }



}
