package com.feng.newline.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L1005K次取反后最大化的数组和
 * @author: Ladidol
 * @description: 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * @date: 2022/8/13 18:04
 * @version: 1.0
 */
public class L1005K次取反后最大化的数组和 {
    class Solution {
        //注意的是这里是数组总和，不是子序列总和，所以不用在乎顺序且需要全加。
        public int largestSumAfterKNegations(int[] nums, int k) {
            // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();
//            Arrays.sort(nums, (o1, o2) -> Math.abs(o2) - Math.abs(o1));//只能操作Integer[]数组

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && k > 0) {
                    nums[i] = -nums[i];
                    k--;
                }
            }
            if (k % 2 == 1) {//剩余奇数个次数的话，就进行绝对值最小数取反。
                nums[nums.length - 1] = -nums[nums.length - 1];
            }
            return Arrays.stream(nums).sum();
        }
    }
}
