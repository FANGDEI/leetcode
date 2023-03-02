package com.dyw.leetcode.剑指Offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * <p>
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author Devil
 * @since 2022-09-11-10:59
 */
@SuppressWarnings("all")
public class O58II左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(new O58II左旋转字符串().reverseLeftWords("abcdefg", 2));
    }

    /**
     * 不申请任何额外空间做法
     *
     * 具体步骤：
     * 1. 反转区间为前n的子串
     * 2. 反转区间为n到末尾的子串
     * 3. 反转整个字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,s.length()-1);
        reverseString(sb,0, s.length()-1);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
