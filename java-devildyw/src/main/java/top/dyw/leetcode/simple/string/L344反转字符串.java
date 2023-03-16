package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-23-13:52
 */
@SuppressWarnings("all")
public class L344反转字符串 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new L344反转字符串().reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }

    }

    public void reverseString(char[] s) {
        int n = s.length;
        char ch;
        for (int i = 0; i < n / 2; i++) {
            ch = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = ch;
        }
    }
}
