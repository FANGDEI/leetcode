package top.dyw.leetcode.Hot100;
import java.util.*;
public class L169多数元素 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
