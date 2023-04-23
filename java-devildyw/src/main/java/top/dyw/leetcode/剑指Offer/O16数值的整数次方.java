package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/23 19:09
 **/
@SuppressWarnings("all")
public class O16数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(new O16数值的整数次方().myPow(2.0, 10));
    }

    /**
     * 快速幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x==0) return 0;
        long b = n;
        double res = 1.0;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        /**
         * n 用二进制表示 = 1b1+2b2+4b3+8b4+...+2^m-1*bm; 二进制b只可能为0 或者 1
         * x 的 n次方就可以写为 x^(1b1+2b2+4b3+8b4+...+2m-1bm) = x^1b1*x^2b2*x^4b3*...*x^(2^(m-1)*bm)
         *
         */
        while (b>0){
            if ((b&1)==1) res*=x; //判断b的最右边是否为一 是则相乘 不是1的话相当于 res*1
            x*=x; //这里用x*=x  x的2幂次
            b>>=1;
        }
        return res;
    }
}
