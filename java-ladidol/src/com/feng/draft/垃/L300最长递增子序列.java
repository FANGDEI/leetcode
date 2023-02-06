package com.feng.draft.垃;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/25 16:01
 * @Version 1.0
 */
public class L300最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,3,7,101,18};
        System.out.println(new 最长递增子序列().lengthOfLIS(nums));
    }
}
class 最长递增子序列 {
    //dp(i) =max(dp(j))+1，
    // 存在j属于区间[0，i-1],并且num[i]>num[j]。
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    //这里只能这样,因为,如果是元dp[i],就不加一
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
