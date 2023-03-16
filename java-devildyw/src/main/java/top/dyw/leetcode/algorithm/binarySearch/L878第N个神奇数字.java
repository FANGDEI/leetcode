package top.dyw.leetcode.algorithm.binarySearch;

/**
 * @author Devil
 * @since 2022-11-22-11:31
 */
@SuppressWarnings("all")
public class L878第N个神奇数字 {

    public static void main(String[] args) {
        System.out.println(new L878第N个神奇数字().nthMagicalNumber(4, 2, 3));
    }

    static final int MOD = 1000000007;
    /**
     * 容斥原理+二分查找
     * 容斥原理：f(x)表示为小于等于x的神奇数字的个数 ： f(x) = [x/a] + [x/b] - [x/c](可以同时被a和b整除 因为前面相加包含了两个 所以这里减去一个)
     * f(x) 是一个随着x递增单调不减的函数。我们可以通过[二分查找]来进行查找第n个神奇数字
     * @param n
     * @param a
     * @param b
     * @return
     */
    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a,b);
        long r =(long) n* Math.min(a,b);
        int c = lcm(a,b);
        //使用r来不断逼近第n个申请数字
        while (l<=r){
            long mid = l+(r-l)/2;
            //计算mid处的申请数字数量
            long cnt = mid/a + mid/b - mid/c;
            //如果数量大于等于n 则r = mid-1 逼近目标
            if (cnt>=n){
                r = mid-1;
                System.out.println("r:"+r);
            }else{
                //如果小于则l=mid+1 收缩区间
                l = mid+1;
                System.out.println("l:"+l);
            }
        }
        //最后返回结果
        return (int)((r+1)%MOD);

    }

    public int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    private int gcd(int a, int b) {
        return b!=0?gcd(b,a%b):a;
    }
}
