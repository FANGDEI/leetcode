package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-03-13:38
 * <p>
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
@SuppressWarnings("all")
public class L557反转字符串中的单词III {
    public static void main(String[] args) {
        System.out.println(new L557反转字符串中的单词III().reverseWords("Let's take LeetCode contest"));
    }

    /**
     * 简单的JavaSe的 api调用
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {

        String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        sb.append(new StringBuffer().append(s1[0]).reverse().toString());
        for (int i = 1; i < s1.length; i++) {
            sb.append(" ");
            sb.append(new StringBuffer().append(s1[i]).reverse().toString());
        }
        return sb.toString();
    }
}
