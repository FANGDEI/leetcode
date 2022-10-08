package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/7 13:54
 * @description: 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class L448找到所有数组中消失的数字 {


    //巧方法
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述：通过类似原地哈希的方法：对出现过的数字nums[i]-1作为下标的每一个值都变成负数，没变成负数的的下标就是缺失的数。
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
    //原地哈希也能做，有空来做一下。


}