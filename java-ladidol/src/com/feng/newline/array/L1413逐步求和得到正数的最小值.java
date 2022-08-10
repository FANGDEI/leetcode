package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1413逐步求和得到正数的最小值
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * 示例 1：
 * <p>
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * 累加求和
 *                 startValue = 4 | startValue = 5 | nums
 *                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * @date: 2022/8/9 19:50
 * @version: 1.0
 */
public class L1413逐步求和得到正数的最小值 {


    //前缀和取最小值。
    class Solution {
        public int minStartValue(int[] nums) {
            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i - 1] + nums[i];
                min = Math.min(min, nums[i]);
            }
            if (min >= 1) return 1;
            return -min + 1;
        }
    }
}
