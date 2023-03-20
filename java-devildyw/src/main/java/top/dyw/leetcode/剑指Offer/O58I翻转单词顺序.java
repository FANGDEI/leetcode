package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/03/20 20:11
 **/
@SuppressWarnings("all")
public class O58I翻转单词顺序 {

    public static void main(String[] args) {
        System.out.println(new O58I翻转单词顺序().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);

    }




}
