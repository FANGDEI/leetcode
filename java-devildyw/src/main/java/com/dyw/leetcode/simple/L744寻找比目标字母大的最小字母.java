package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @since 2022-06-09-15:58
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 */
@SuppressWarnings("all")
public class L744寻找比目标字母大的最小字母 {
    public static void main(String[] args) {
        System.out.println(new L744寻找比目标字母大的最小字母().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        char c = 0;

        if (target>=letters[length-1]){
            for (int i = 0; i < length; i++) {
                if (target<letters[i]+26){
                    c = letters[i];
                    break;
                }
            }
        }else{
            for (int i = 0; i < length; i++) {
                if (target<letters[i]){
                    c = letters[i];
                    break;
                }
            }
        }

        return c;
    }
}
