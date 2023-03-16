package top.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-17-14:17
 * <p>
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 */
@SuppressWarnings("all")
public class L453最小操作次数使数组元素相等 {
    public static void main(String[] args) {

    }

    /**
     * 每次操作会将n-1个元素增加一 可以反转思想每次让1个元素减一
     * 知道最后元素都与最小的那个元素相等即可,.
     */
    public int minMoves(int[] nums) {
        //首先找出最小值
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < minNum) {
                minNum = num;
            }
        }
        int result = 0;

        //计算每个元素与最小值的差值 即为操作次数
        for (int num : nums) {
            result += num - minNum;
        }

        return result;
    }
}
