package com.feng.leetcode.hot100._07排序;

import java.util.Arrays;

public class h169多数元素 {

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }

}
