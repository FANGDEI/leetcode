package com.feng.面试题.美团.M23年春.M0318;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/18 10:39
 * @description: 输入描述
 * 一行，一个字符串。字符串中仅由小写英文字符构成。
 * <p>
 * 保证字符串不会是空字符串。
 * <p>
 * 字符串长度介于 [1, 100000] 之间。
 * <p>
 * 输出描述
 * 一行，一个在题目条件限制下所可以获得的字典序最小的回文字符串。
 */
public class M3 {


    /**
     * 双指针 左右双指针，从左和从右开始遍历
     * 为了使字典序最小，我们在找到不同的情况下，如果右边比较大，就把右边的变成和左边一样的，不然就是左边跟着变小
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 0;
        //先找不相同的
        for (int left = 0, right = n - 1; left <= right && count < 2; left++, right--) {
            char l = chars[left];
            char r = chars[right];
            if (l > r) {
                chars[left] = r;
                count++;
            } else if (l < r) {
                chars[right] = l;
                count++;
            }
        }
        //再找相同中可以换的元素
//        System.out.println(new String(chars));
        //发现count并没有减到零，这里就需要改变相同的值
        if (count == 1) {
            System.out.println(new String(chars));
            return;
        }
        for (int left = 0, right = n - 1; left <= right && count < 2; left++, right--) {
            char l = chars[left];
            if (l != 'a') {
                chars[left] = 'a';
                chars[right] = 'a';
                count += 2;
            }
        }
//        System.out.println("count = " + count);
        System.out.println(new String(chars));
    }
}
