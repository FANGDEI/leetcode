package top.dyw.leetcode.algorithm.binarySearch;

/**
 * @author Devil
 * @since 2022-08-28-11:45
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 */
@SuppressWarnings("all")
public class L367有效的完全平方数 {
    public static void main(String[] args) {
        System.out.println(new L367有效的完全平方数().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left<=right){
            int mid = left + (right-left)/2;
            if ((long)mid*mid < num){
                left = mid +1;
            }else if ((long)mid*mid > num){
                right = mid -1 ;
            }else{
                return true;
            }
        }
        return false;
    }
}
