package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1470重新排列数组
 * @author: Ladidol
 * @description: 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * @date: 2022/8/29 15:38
 * @version: 1.0 每日一题
 */
public class L1470重新排列数组 {
    //双指针
    class Solution1 {
        public int[] shuffle(int[] nums, int n) {
            int front = 0, end = n;
            int[] res = new int[nums.length];//注意nums.length = 2 * n
            for (int i = 0; i < nums.length; ) {
                res[i++] = nums[front++];
                res[i++] = nums[end++];
            }
            return res;
        }
    }

    //新开一个数组进行模拟
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int front = 0, end = n;
            int[] res = new int[nums.length];
            int k = 0;
            while (k < nums.length) {
                res[k++] = nums[front++];
                res[k++] = nums[end++];
            }
            return res;
        }
    }


}
