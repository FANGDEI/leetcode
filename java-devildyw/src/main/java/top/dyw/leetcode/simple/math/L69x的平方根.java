package top.dyw.leetcode.simple.math;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/26 11:08
 **/
@SuppressWarnings("all")
public class L69x的平方根 {

    public static void main(String[] args) {
        System.out.println(new L69x的平方根().mySqrt(4));
    }

    /**
     * 二分法 注意边界条件 当x为1的时候
     * mid * mid 会不会超过int上限
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right){
            int mid = left + ((right - left) / 2);
            if ((long) mid * mid > x){
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }
}
