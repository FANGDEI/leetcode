package top.dyw.leetcode.Hot100;

public class L45跳跃游戏II {
    public int jump(int[] nums) {
        if (nums.length==1) {
            return 0;
        }
        int count = 1;
        int curEnd = nums[0]; // 当前这一步能走到的尽头
        int maxReach = nums[0]; // 全局能走到的最大尽头

        for (int i=0; i<nums.length-1; i++) {
            maxReach = Math.max(i+nums[i], maxReach);
            if (i==curEnd) {
                count++;
                curEnd = maxReach;

                if (curEnd >= nums.length-1) {
                    break;
                }
            }
        }
        return count;
    }
}
