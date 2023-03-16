package top.dyw.leetcode.algorithm.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * @author Devil
 * @since 2022-11-11-12:35
 */
@SuppressWarnings("all")
public class L213打家劫舍II {

    public static void main(String[] args) {

    }

    /**
     * 与L198打家劫舍区别在于 它是成环的 所以我们要考虑成环相邻的情况
     *
     * 动态规划：成环的情况有三种
     * <p>
     * 情况一：考虑不包含首尾元素
     * <p>
     * 情况二：考虑包含首元素，不包含尾元素
     * <p>
     * 情况三：考虑包含尾元素，不包含首元素
     * <p>
     * 而情况二 和 情况三 都包含了情况一了，所以只考虑情况二和情况三就可以了。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length==0||nums==null){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        //两种情况
        return Math.max(robAction(nums,0,nums.length-2),robAction(nums,1,nums.length-1));
    }

    private int robAction(int[] nums, int start, int end) {
        if (end==start){
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];
    }


}
