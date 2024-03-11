package com.feng.面试题.大华;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/8 22:03
 * @description: {}
 */
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] split = s.split("\\[|\\]");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i + 1 < split.length; i += 2) {
            int num = Integer.parseInt(split[i]);
            String str = split[i + 1];
            for (int j = 0; j < num; j++) {
                ans.append(str);
            }
        }
        System.out.println(ans);




    }
}
