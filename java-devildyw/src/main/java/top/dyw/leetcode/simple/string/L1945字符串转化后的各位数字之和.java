package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-12-15-12:04
 */
@SuppressWarnings("all")
public class L1945字符串转化后的各位数字之和 {

    public static void main(String[] args) {
        System.out.println(new L1945字符串转化后的各位数字之和().getLucky("leetcode", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)-96);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (int j = 0; j < sb.length(); j++) {
                sum+=sb.charAt(j)-'0';
            }
            sb.delete(0,sb.length());
            sb.append(sum);
        }
        return sum;
    }
}
