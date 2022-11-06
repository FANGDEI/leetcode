package com.dyw.leetcode.simple.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * @author Devil
 * @since 2022-11-06-13:07
 */
@SuppressWarnings("all")
public class L1678设计Goal解析器 {
    public static void main(String[] args) {
        System.out.println(new L1678设计Goal解析器().interpret("G()(al)"));
    }


    /**
     * 使用 栈
     * @param command
     * @return
     */
    public String interpret(String command) {
        Deque<Character> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i)=='G'){
                sb.append('G');
            }else if (i+1<command.length()&&command.substring(i,i+2).equals("()")){
                sb.append("o");
                i++;
            } else if (i + 3 < command.length()&&command.substring(i,i+4).equals("(al)")) {
                sb.append("al");
            }
        }
        return sb.toString();

    }
}
