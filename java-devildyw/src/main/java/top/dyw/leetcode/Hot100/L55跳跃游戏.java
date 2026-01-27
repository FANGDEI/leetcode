package top.dyw.leetcode.Hot100;

public class L55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums[0];
        int index = 0;
        while (index<=n && index < nums.length) {
            n = Math.max(n, index + nums[index]);
            index++;
        }

        return n >= nums.length-1;
    }
}
