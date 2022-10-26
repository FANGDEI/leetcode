package com.feng.newline.array;

/**
 * @author: ladidol
 * @date: 2022/10/24 23:30
 * @description: 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 * left中的每个元素都小于或等于right中的每个元素。
 * left 和right都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回left的长度。
 * 用例可以保证存在这样的划分方法。
 * 示例 1：
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 */
public class L915分割数组 {

    //前缀和
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：简单的题，但是是带着emo情绪写的，写了很久，也思考了很久。
         */
        public int partitionDisjoint(int[] nums) {

            int n = nums.length;
            int[] min = new int[n];
            min[n - 1] = nums[n - 1];
            int tmpMax = -1;


            for (int i = n - 2; i >= 0; i--) {
                min[i] = Math.min(min[i + 1], nums[i]);
            }
            for (int i = 0; i < n - 1; i++) {
                tmpMax = Math.max(nums[i], tmpMax);
                if (tmpMax <= min[i + 1]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

}