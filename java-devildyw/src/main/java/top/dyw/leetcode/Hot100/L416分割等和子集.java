package top.dyw.leetcode.Hot100;

public class L416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxSum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, nums[i]);
        }

        if (sum % 2==1) {
            return false;
        }

        int target = sum/2;
        if (maxSum > target) {
            return false;
        }
        // dp[i][j] 表示从0-i 中选取的元素能否使得和等于j
        boolean[][] dp = new boolean[n+1][target+1];
        for (int i=0; i<n; i++) {
            // 可以不选
            dp[i][0] = true;
        }
        //自身
        dp[0][nums[0]] = true;
        for (int i=1; i<n; i++) {
            for (int j=1; j<=target; j++) {
                if (j>=nums[i]) {
                    // 看看i-1之前能否装满j 或者 i-1之前的能不能装满 j-nums[i] 如果能那就为true
                    // 因为要么装 要么不装嘛 装的话 得j-nums[i] 能装才行。
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                } else {
                    // 如果 j>=nums[i] 那么肯定不能装这个nums[i]元素 因为超过了 只能看i-1能不能装满j了
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];

    }
}
