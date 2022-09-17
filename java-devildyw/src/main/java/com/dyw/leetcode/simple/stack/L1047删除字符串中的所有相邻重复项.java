package com.dyw.leetcode.simple.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * @author Devil
 * @since 2022-09-17-11:30
 */
@SuppressWarnings("all")
public class L1047删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
        System.out.println(new L1047删除字符串中的所有相邻重复项().removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty()&&deque.peek()==c){
                deque.pop();
                continue;
            }
            deque.push(c);
        }

        while (!deque.isEmpty()){
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }

}
