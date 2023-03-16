package top.dyw.leetcode.simple.hash;

/**
 * @author Devil
 * @since 2023-01-11-8:56
 */
@SuppressWarnings("all")
public class L2283判断一个数的数字计数是否等于数位的值 {

    public static void main(String[] args) {
        System.out.println(new L2283判断一个数的数字计数是否等于数位的值().digitCount("1210"));
    }

    public boolean digitCount(String num) {
        int[] hash = new int[10];

        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i]-'0']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!(hash[i] ==chars[i]-'0')){
                return false;
            }
        }
        return true;

    }
}
