package com.feng.面试题.腾讯云智;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/10 11:07
 * @description: {}
 */
public class First {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = n; i < 2*n; i++) {
            if (i==2*n-1){
                System.out.print(i);
                break;
            }
            System.out.print(i+" ");
        }




    }

}
