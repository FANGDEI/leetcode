package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-28-12:19
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
@SuppressWarnings("all")
public class L434字符串中的单词数 {
    public static void main(String[] args) {
        System.out.println(new L434字符串中的单词数().countSegments01("Hello, my name is John"));
    }

    /**
     * 面向测试数据编程
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        if (s != null && s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split("[ ]+");
        if (s.charAt(0) == ' ') {
            return s1.length - 1 < 0 ? 0 : s1.length - 1;
        }


        return s1.length;
    }

    /**
     * 使用非正则表达式分割 通过单词前面是否有空格进行分割
     *
     * @param s
     * @return
     */
    public int countSegments01(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            //第一个单词直接且不为空格直接计入 后续单词只有遇到单词前面有空格才计入且单词不为空格
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
