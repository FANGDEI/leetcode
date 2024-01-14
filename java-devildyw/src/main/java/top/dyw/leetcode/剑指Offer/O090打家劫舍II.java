package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/08/09 14:02
 **/
@SuppressWarnings("all")
public class O090打家劫舍II {

    public static void main(String[] args) {

    }

    /**
     * 由于首位相连所以这里我们考虑两种情况
     * 取首元素，因为相连成环那么尾元素就不能选用
     * 相同取尾元素，那么首元素就不能选用
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        //这里下标控制是否选用首位元素
        return Math.max(robAction(nums,0,nums.length-2),robAction(nums,1,nums.length-1));
    }

    private int robAction(int[] nums, int start, int end) {
        if (start==end){
            return nums[start];
        }

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start],nums[start+1]);

        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[end];
    }
}
