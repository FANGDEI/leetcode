package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-24-14:04
 * <p>
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 */
@SuppressWarnings("all")
public class L389找不同 {
    public static void main(String[] args) {
        System.out.println(new L389找不同().findTheDifference("", "y"));
    }

    public char findTheDifference(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i)-'a']++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return (char)(i+'a');
            }
        }
        return 'a';
    }
}
