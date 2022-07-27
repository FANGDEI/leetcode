package com.dyw.leetcode.algorithm.doublePointer;

/**
 * @author Devil
 * @since 2022-07-14-10:44
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
@SuppressWarnings("all")
public class L344反转字符串 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new L344反转字符串().reverseString(chars);
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}
