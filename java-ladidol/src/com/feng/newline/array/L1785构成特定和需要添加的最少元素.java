package com.feng.newline.array;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/16 14:43
 * @description: {}
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 */
public class L1785构成特定和需要添加的最少元素 {
    //贪心(力扣会超时)
    class Solution1 {
        public int minElements(int[] nums, int limit, int goal) {
//            int sum = Arrays.stream(nums).sum();
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            boolean flag = goal > sum;
            int sep = goal > sum ? limit : -limit;
            int ans = 0;
            while (sum != goal) {
                if (flag && sum + sep > goal) {
                    return ans + 1;
                } else if (!flag && sum + sep < goal) {
                    return ans + 1;
                }
                sum += sep;
                ans++;
            }
            return ans;
        }
    }


    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
//            long sum = Arrays.stream(nums).sum();
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long cha = Math.abs(sum - goal);
            return (int) ((cha + limit - 1) / limit);
        }
    }
}
