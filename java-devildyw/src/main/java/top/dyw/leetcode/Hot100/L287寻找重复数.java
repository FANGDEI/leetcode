package top.dyw.leetcode.Hot100;

import java.util.*;

public class L287寻找重复数 {
    public int findDuplicate(int[] nums) {
        // 实际上是一个环形连表 判断是否有环
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        // 找到入口
        fast = 0;
        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;

    }
}