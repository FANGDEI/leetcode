package top.dyw.write_exam.kuaishou;

import java.lang.reflect.Array;
import java.util.Arrays;

public class K3最长递增子序列 {

    public static void main(String[] args) {
        System.out.println(new K3最长递增子序列().lengthOfLIS(new int[]{1, 2, 3, 10, 5, 6, 7, 8}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
        }
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
