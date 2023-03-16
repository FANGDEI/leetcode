package top.dyw.leetcode.TOP面试题;

/**
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author Devil
 * @since 2022-11-01-13:12
 */
@SuppressWarnings("all")
public class L7整数反转 {

    public static void main(String[] args) {
        System.out.println(new L7整数反转().reverse(12345678));
    }

    /**
     * 难点考虑溢出的情况
     * -2147483648<=result<=2147483647
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x!=0){
            int temp = x%10;
            //判断溢出情况
            if (result>214748364||(result==214748364&&temp>7)){
                return 0;
            }
            if (result<-214748364||(result==-214748364&&temp<-8)){
                return 0;
            }
            result = result*10+temp;
            x/=10;
        }
        return result;
    }
}
