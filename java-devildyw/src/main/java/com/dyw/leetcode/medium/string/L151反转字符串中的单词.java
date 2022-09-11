package com.dyw.leetcode.medium.string;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * @author Devil
 * @since 2022-09-11-10:36
 */
@SuppressWarnings("all")
public class L151反转字符串中的单词 {

    public static void main(String[] args) {
        System.out.println(new L151反转字符串中的单词().reverseWords("the sky is blue"));
    }

    /**
     * 移除多余空格
     *
     * 将整个字符串反转
     *
     * 将每个单词反转
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //去除首位以及中间的多余空格
        StringBuilder sb = removeSpace(s);
        //翻转整个字符串
        sb.reverse();
        //再翻转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start<n){
            while (end<n && sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start = end + 1;
            end = start +1;
        }
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        //翻转字符串

        while (start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    private StringBuilder removeSpace(String s) {
        //首先取出首位的空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }

        StringBuilder sb = new StringBuilder();
        while (start<=end){
            char c = s.charAt(start);
            //保证中间如果有空格只会有一个空格计入
            if (c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }


}
