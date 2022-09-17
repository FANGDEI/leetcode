package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1619删除某些元素后的数组均值
 * @author: Ladidol
 * @description: 给你一个整数数组arr，请你删除最小5%的数字和最大 5%的数字后，剩余数字的平均值。
 * 与 标准答案误差在10-5的结果都被视为正确结果。
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出：4.00000
 * @date: 2022/9/14 10:50
 * @version: 1.0
 */
public class L1619删除某些元素后的数组均值 {
    class Solution {
        public double trimMean(int[] arr) {
            int n = arr.length;
            int k = (int) (n * 0.05);
            Arrays.sort(arr);

            int sum = 0;
            for (int i = k; i < n - k; i++) {
                sum += arr[i];
            }
            return (double) sum / (n - 2 * k);
        }
    }
}
