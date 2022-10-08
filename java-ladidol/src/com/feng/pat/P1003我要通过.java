package com.feng.pat;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/6 19:18
 * @description:
 */
public class P1003我要通过 {


    /*
     * 参数：[args]
     * 返回值：void
     * 作者： ladidol
     * 描述：10
        PAT
        PAAT
        AAPATAA
        AAPAATAAAA
        xPATx
        PT
        Whatever
        APAAATAA
        APT
        APATTAA
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();//跳一行。
        outer:
        for (int i = 0; i < n; i++) {
            String cur = scan.nextLine();
            int p = findIndex(cur, 'P'), t = findIndex(cur, 'T');
            if (p == -1 || t == -1) {
                System.out.println("NO");
                continue;
            }
            char[] chars = cur.toCharArray();
            //寻找有多少个A
            int first = 0;
            for (int j = 0; j < p; j++) {
                if (chars[j] == 'A') {
                    first++;
                } else {
                    System.out.println("NO");
                    continue outer;
                }
            }
            //寻找有多少个A
            int second = 0;
            for (int j = p + 1; j < t; j++) {
                if (chars[j] == 'A') {
                    second++;
                } else {
                    System.out.println("NO");
                    continue outer;
                }
            }
            //寻找有多少个A
            int third = 0;
            for (int j = t + 1; j < cur.length(); j++) {
                if (chars[j] == 'A') {
                    third++;
                } else {
                    System.out.println("NO");
                    continue outer;
                }
            }
            if (first + second + third == 0) System.out.println("NO");
            else if (second == 0) System.out.println("NO");
            else if (first * second != third) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    static int findIndex(String str, Character c) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }


    class Devildyw{
        /**
         * 参数：[args]
         * 返回值：void
         * 作者： ladidol
         * 描述：什么神仙代码！
         */
        public  void main(String[] args) {
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
}


