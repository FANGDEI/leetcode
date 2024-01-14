package com.feng.面试题.数字马力;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/10/9 19:16
 * @description: {}
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(new String(chars));


    }

}
