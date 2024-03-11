package com.feng.面试题.恒生电子.秋招;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/8 19:15
 * @description: {}
 */
public class Main {

    static class Stuff{
        static int x = 10;
        static  {
            x+=5;
        }

        public static void main(String[] args) {
            System.out.println("x="+x);
        }

        static {
            x/=3;
        }

    }


}
