package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @since 2022-06-17-13:29
 * <p>
 * 我们要把给定的字符串 S从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，
 * 那么我们应该把这个字母写到下一行。我们给定了一个数组widths，这个数组widths[0] 代表 'a' 需要的单位，widths[1] 代表 'b'
 * 需要的单位，...，widths[25] 代表 'z' 需要的单位。
 * <p>
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 */
@SuppressWarnings("all")
public class L806写字符串需要的行数 {
    public static void main(String[] args) {

    }

    private static final Integer MAX_WIDTH = 100;

    /**
     * 模拟 遍历字符串 找到对应字符在widths数组中的所需单位 如果该行前面的width加上这个单位大于了100那么就开新的一行
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        //初始化
        int lines = 1;
        int width = 0;

        //遍历
        for (int i = 0; i < s.length(); i++) {
            //找到对应字符的单位
            int need = widths[s.charAt(i) - 'a'];
            //width加上need
            width += need;
            //如果此时的width超过了100
            if (width > 100) {
                //开新的一行
                lines++;
                //将width赋值位need(该字符单词将会填入下一行)
                width = need;
            }
        }
        return new int[]{lines, width};


    }
}
