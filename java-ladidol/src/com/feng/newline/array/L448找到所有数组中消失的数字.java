package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
    class Solution1 {
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


    //类似原地哈希
    class Solution232 {// 2022年10月20日11:44:28复习

        /**
         * 参数：[nums]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述： 通过类似原地哈希的方法，这一次不用相反数转换，用取模运算，同时修改了值也能取模导致一样。
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                nums[(nums[i] - 1) % n] += n;
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) res.add(i + 1);//没有通过下标指引更改数字，其下标就是缺失的数字。
            }
            return res;
        }
    }


    //原地哈希也能做
    class Solution {
        /**
         * 参数：[nums]
         * 返回值：java.util.List<java.lang.Integer>
         * 作者： ladidol
         * 描述： 对于num[i] != i+1的情况，就是不存在的数字，因为数字正常的话是1到n
         */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; ) {
                if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) swag(nums, i, nums[i] - 1);//换到当前i下：nums[i] = i + 1
                else i++;
            }
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }

        void swag(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


}