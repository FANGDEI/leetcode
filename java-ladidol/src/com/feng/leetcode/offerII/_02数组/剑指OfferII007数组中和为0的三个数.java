package com.feng.leetcode.offerII._02数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/3 16:26
 * @description: {}
 */
public class 剑指OfferII007数组中和为0的三个数 {

    //三指针，i,j,k进行范围性地毯式搜索
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (j > i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
                        j++;//注意不要忘记
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            return res;

        }
    }


}
