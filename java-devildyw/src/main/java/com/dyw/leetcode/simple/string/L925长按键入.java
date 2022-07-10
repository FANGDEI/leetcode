package com.dyw.leetcode.simple.string;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-07-10-12:25
 *
 * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
 *
 */
@SuppressWarnings("all")
public class L925长按键入 {
    public static void main(String[] args) {
        System.out.println(new L925长按键入().isLongPressedName("alex", "aaleex"));
    }

    /**
     * 双指针
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        //初始化指针
        int i =0, j=0;
        //在遍历typed的基础上比较与name的关系
        while (j<typed.length()){
            //如果在i<name.length的情况下 当前双指针对应的字符相等的话 即现在typed作为name的一部分 那么双指针都向右移动
            if (i<name.length()&&name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
             //如果不相等 就判断是否是长按键入 即现在j指向的字符是否与前一个字符相等
            }else if (j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{ //如果两种情况都不满足就返回false
                return false;
            }
        }
        //另一个种情况 即typed中没有name的部分 即并非长安键入引起的错误
        return i==name.length();

    }
}
