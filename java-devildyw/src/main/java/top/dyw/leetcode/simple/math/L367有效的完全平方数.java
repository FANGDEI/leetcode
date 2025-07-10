package top.dyw.leetcode.simple.math;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/07/04 10:17
 **/
@SuppressWarnings("all")
public class L367有效的完全平方数 {

    public static void main(String[] args) {
        System.out.println(new L367有效的完全平方数().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            }  else {
                return true;
            }
        }
        return false;
    }
}
