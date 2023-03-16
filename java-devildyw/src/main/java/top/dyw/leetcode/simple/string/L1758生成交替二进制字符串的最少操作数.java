package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-11-29-11:22
 */
@SuppressWarnings("all")
public class L1758生成交替二进制字符串的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new L1758生成交替二进制字符串的最少操作数().minOperations("1111"));
    }

    /**
     * 最终状态的字符串无非就两种状态，一种是1开头交替出现 另一种是0开头交替出现 我们只要计算出所给字符串转换为两种情况的值再比较大小即可
     *
     * 注意到，变成这两种不同的交替二进制字符串所需要的最少操作数加起来等于 ss 的长度，我们只需要计算出变为其中一种字符串的最少操作数，就可以推出另一个最少操作数，然后取最小值即可。
     *
     * @param s
     * @return
     */
    public int minOperations(String s) {
        char[] chars = s.toCharArray();

        int min1 = 0;
        /**
         * 转变为以1开头的最终状态的操作数 min1
         */
        for (int i = 0; i < chars.length; i++) {
            if (i%2==0&&chars[i]!='1'){
                min1++;
            }else if (i%2!=0&&chars[i]!='0'){
                min1++;
            }
        }

        /**
         * 转变为以0开头的最终状态的操作数 即min2 min2 = length - min1（规律）
         */
        return Math.min(min1,chars.length-min1);
    }
}
