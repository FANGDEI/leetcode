package com.feng.面试题.美团.M24年春.M0309;


import java.util.Scanner;

/**
 * MT 是美团的缩写，因此小美很喜欢这两个字母。
 * 现在小美拿到了一个仅由大写字母组成字符串，她可以最多操作k次，每次可以修改任意一个字符。小美想知道，操作结束后最多共有多少个'M'和'T'字符
 * 5 2
 * MTUAN
 * 题集如下：
 *
 * https://www.zhihu.com/search?type=content&q=%E5%B9%B6%E6%9F%A5%E9%9B%86%20%E5%88%A0%E9%99%A4
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = scan.nextInt(), k = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        char[] chars = str.toCharArray();
        int ans = 0;
        for (char c : chars) {
            if (c == 'M' || c == 'T') {
                ans++;
            }
        }
        ans = Math.min((ans + k), chars.length);
        System.out.println(ans);


    }

}
