package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/05/09 22:03
 **/
@SuppressWarnings("all")
public class O65不用加减乘除做加法 {
    public static void main(String[] args) {

    }

    /**
     * 记录进位c，计算a+b 在计算 a+c
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b!=0){ //b即代表b本身也可以代表进位，进位不为0就继续计算
            int c = (a&b)<<1; //计算进位
            a ^=b; //计算a与b的和 也计算a与进位的和
            b = c; //b记录进位c
        }
        return a;
    }
}
