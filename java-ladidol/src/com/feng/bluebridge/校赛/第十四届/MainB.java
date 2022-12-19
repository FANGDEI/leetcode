package com.feng.bluebridge.校赛.第十四届;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/17 9:43
 * @description: {}
 */
public class MainB {
    //模拟，从最外层网最里层模拟
    public static void main(String[] args) {
        //现在数组模拟一下
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            //四条方向
            //上边
            for (int j = i; j < n - i; j++) {
                res[i][j] = s.charAt(i);//左边
                res[n - i - 1][j] = s.charAt(i);//右边
                res[j][i] = s.charAt(i);//上边
                res[j][n - i - 1] = s.charAt(i);//下边
            }

        }
        for (char[] re : res) {
            System.out.println(new String(re));
        }
    }
}
