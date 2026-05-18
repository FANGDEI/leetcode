package top.dyw.leetcode.Hot100;

public class L45跳跃游戏II {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int curEnd = 0;
        int count = 0;

        for (int i=0; i<n-1; i++) {
            maxReach = Math.max(maxReach, i+nums[i]);
            if (i==curEnd) {
                count++;
                curEnd = maxReach;
            }

            if (curEnd >= n-1) {
                break;
            }
        }
        return count;
    }
}
