package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-04-13:11
 * <p>
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 */
@SuppressWarnings("all")
public class L709转换成小写字母 {
    public static void main(String[] args) {
        System.out.println(new L709转换成小写字母().toLowerCase("Hello"));
    }

    public String toLowerCase(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String toLowerCase01(String s) {
        return s.toLowerCase();
    }
}
