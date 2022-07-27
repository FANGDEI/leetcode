package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-08-11:49
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
@SuppressWarnings("all")
public class L844比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(new L844比较含退格的字符串().backspaceCompare("abcd", "bbcd"));
    }

    /**
     * 使用StringBuffer模拟栈
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        //比较结果
        return build(s).equals(build(t));
    }

    private String build(String s) {
        //初始化栈 之所以用Stringbuffer是因为它可以很轻松的将结果转化为字符串
        StringBuffer sb = new StringBuffer();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            //如果不为'#' 就加入结果集
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {//如果是'#'
                //但结果集的长度要大于0时 才会去踢出最后一个元素
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        //返回结果字符串
        return sb.toString();
    }
}
