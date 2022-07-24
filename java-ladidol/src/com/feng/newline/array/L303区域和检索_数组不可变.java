package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L303区域和检索_数组不可变
 * @author: Ladidol
 * @description:
 * @date: 2022/7/23 20:17
 * @version: 1.0
 */
public class L303区域和检索_数组不可变 {
    class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            int n = nums.length;
            // 前缀和数组下标从 1 开始，因此设定长度为 n + 1（模板部分）
            sum = new int[n + 1];
            // 预处理除前缀和数组（模板部分）
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            //加一处理
            return sum[++right] - sum[left];
        }
    }
}
