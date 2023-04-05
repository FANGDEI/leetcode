package top.dyw.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-11-17-15:06
 */
@SuppressWarnings("all")
public class L300最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        /**
         * dp[i]表示i之前包括i的以num[i]结尾的最长上升子序列长度
         */
        int[] dp = new int[nums.length];
        /**
         * 对于每一个i，对应的dp[i]起始大小至少都是1
         */
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            //遍历顺序i从0向length遍历 j 则从 0 向 i-1 遍历刷新最大值
            for (int j = 0; j < i; j++) {
                //位置i的最长上升子序列等于j从0到i-1各个位置的最长上升子序列 + 1 的最大值
                //如果nums[i] > nums[j] 时才更新 才能满足 递增
                if (nums[i] > nums[j]) {
                    //这里只是为了取到dp[j]+1的最大值 因为dp[i]初始化是1 只能被dp[j]+1一直刷新
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //最后根据dp数组中的最大值取得最终结果
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;


    }

}
