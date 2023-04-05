package top.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-05-19-12:49
 * <p>
 * <p>
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 */
@SuppressWarnings("all")
public class L500键盘行 {
    public static void main(String[] args) {

    }

    /**
     * 采用三个hashset存储
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {

        //这里大小写一起存是为了节省时间 防止一致调用Character.toLowerCase() 耗时
        String strHang1 = "qwertyuiopQWERTYUIOP";
        String strHang2 = "asdfghjklASDFGHJKL";
        String strHang3 = "zxcvbnmZXCVBNM";
        HashSet<Character> hang1 = new HashSet<>();
        HashSet<Character> hang2 = new HashSet<>();
        HashSet<Character> hang3 = new HashSet<>();

        int index = 0;
        String[] result = new String[words.length];

        for (int i = 0; i < strHang1.length(); i++) {
            hang1.add(strHang1.charAt(i));
        }
        for (int i = 0; i < strHang2.length(); i++) {
            hang2.add(strHang2.charAt(i));
        }
        for (int i = 0; i < strHang3.length(); i++) {
            hang3.add(strHang3.charAt(i));
        }

        for (String word : words) {
            char ch = word.charAt(0);
            int n1 = 0, n2 = 0;
            int length = word.length();
            if (hang1.contains(ch)) {
                n1 = n2 = 1;
            } else if (hang2.contains(ch)) {
                n1 = n2 = 2;
            } else if (hang3.contains(ch)) {
                n1 = n2 = 3;
            }
            for (int i = 1; i < length && n1 == n2; i++) {
                char c = word.charAt(i);
                if (hang1.contains(c)) {
                    n2 = 1;
                } else if (hang2.contains(c)) {
                    n2 = 2;
                } else if (hang3.contains(c)) {
                    n2 = 3;
                }
            }
            if (n1 == n2) {
                result[index++] = word;
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
