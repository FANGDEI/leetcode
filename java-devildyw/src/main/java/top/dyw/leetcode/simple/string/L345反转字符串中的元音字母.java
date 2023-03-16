package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-23-14:03
 */
@SuppressWarnings("all")
public class L345反转字符串中的元音字母 {
    public static void main(String[] args) {
        System.out.println(new L345反转字符串中的元音字母().reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        //元音字母字符串包括大小写
        String str = "aeiouAEIOU";
        int n = s.length();

        char temp;

        int i = 0, j = n - 1;
        while (i < j) {
            //从左往右找到元音字母
            while (i < n && !(str.indexOf(chars[i]) >= 0)) {
                ++i;
            }
            //从右往左找到元音字母
            while (j > 0 && !(str.indexOf(chars[j]) >= 0)) {
                --j;
            }
            if (i < j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            //交换过后需要要走一步防止陷入循环
            ++i;
            --j;
        }

        return new String(chars);
    }
}
