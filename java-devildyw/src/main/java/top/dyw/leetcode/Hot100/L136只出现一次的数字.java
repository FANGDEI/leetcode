package top.dyw.leetcode.Hot100;

public class L136只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
