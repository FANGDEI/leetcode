package com.dyw.pat.simple;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-06-12:01
 */
@SuppressWarnings("all")
public class P1003我要通过 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String line = input.next();
            //正则匹配 只有PAT这三种字符，xPATx 是正确
            boolean isRight = line.matches("A*PA+TA*");

            //获取 P 前面 A 的个数，如果 P 为0则前面的个数为0.其他同理
            int a = line.indexOf("P");
            //找到T 的位置
            int index = line.indexOf("T");
            int b = index - a - 1; //计算 P 到 T 之间的 A 的个数
            int c = line.length() -a -b - 2;//计算 T 后的 A 的个数
            //打印结果
            System.out.println(isRight&&(a*b==c)?"YES":"NO");
        }
    }
}
