package top.dyw.leetcode.algorithm.dp;

/**
 * @author Devil
 * @since 2022-11-13-16:26
 */
@SuppressWarnings("all")
public class L53最大子数组和 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,sum+=nums[i]);
            if (sum+nums[i]<0){
                sum=0;
            }
        }
        return max;
    }



}
