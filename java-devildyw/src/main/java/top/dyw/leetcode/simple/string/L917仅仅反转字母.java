package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-10-12:10
 * <p>
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 */
@SuppressWarnings("all")
public class L917仅仅反转字母 {
    public static void main(String[] args) {
        System.out.println(new L917仅仅反转字母().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    /**
     * 轻松双指针
     *
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
