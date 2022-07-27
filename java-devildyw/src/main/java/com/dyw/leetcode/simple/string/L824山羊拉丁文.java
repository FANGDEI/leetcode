package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-05-12:54
 * <p>
 * 给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 */
@SuppressWarnings("all")
public class L824山羊拉丁文 {
    public static void main(String[] args) {
        System.out.println(new L824山羊拉丁文().toGoatLatin01("I speak Goat Latin"));
    }

    public String toGoatLatin(String sentence) {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] split = sentence.split("[ ]+");
        StringBuffer sb = new StringBuffer();
        int n = split.length;
        for (int i = 0; i < n; i++) {
            char c = Character.toLowerCase(split[i].charAt(0));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sb.append(split[i] + "ma" + str.substring(0, i + 1));
            } else {
                sb.append(split[i].substring(1, split[i].length()) + split[i].charAt(0) + "ma" + str.substring(0, i + 1));
            }
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String toGoatLatin01(String sentence) {
        String vowels = "aeiouAEIOU";
        int n = sentence.length();
        int i = 0, cnt = 1;
        StringBuffer sb = new StringBuffer();

        //遍历 i为字符串分割的起始标识
        while (i < n) {
            //j则为字符串分割的末尾标识
            int j = i;
            //如果没碰上' ' 就继续寻找 直到找到为止
            while (j < n && sentence.charAt(j) != ' ') {
                ++j;
            }
            ++cnt;
            //当cnt==2的时候还没有一个单词 所以不用添加' '
            if (cnt != 2) {
                sb.append(' ');
            }
            //如果是原因直接分割
            if (vowels.indexOf(sentence.charAt(i)) >= 0) {
                sb.append(sentence.substring(i, j));
            } else {
                //如果不是则需要将第一个字符放到末尾
                sb.append(sentence.substring(i + 1, j));
                sb.append(sentence.charAt(i));
            }
            //加上m
            sb.append('m');
            //根据下标添加'a'
            for (int k = 0; k < cnt; k++) {
                sb.append('a');
            }
            //i变为j+1
            i = j + 1;
        }
        return sb.toString();
    }
}
