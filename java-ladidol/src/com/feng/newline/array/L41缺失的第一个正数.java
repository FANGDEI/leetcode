package com.feng.newline.array;

/**
 * @author: ladidol
 * @date: 2022/10/20 15:07
 * @description: 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class L41缺失的第一个正数 {

    //原地哈希
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：和L448中寻找消失的数字一样，只是那里保证了nums[i]一定是1到n，所以通过nums[i] = i+1并不会越位。
         * 保证一下数组角标不能越位。-2^31 <= nums[i] <= 2^31 - 1
         */
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ) {
                if (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    swag(nums, i, nums[i] - 1);
                } else
                    i++;


            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) return i + 1;
            }
            //注意是寻找最小未出现的正整数。
            return n + 1;
        }

        void swag(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

