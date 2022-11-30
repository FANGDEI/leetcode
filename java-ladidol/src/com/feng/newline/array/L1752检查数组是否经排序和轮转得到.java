package com.feng.newline.array;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/11/27 15:02
 * @description: 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * 源数组中可能存在 重复项 。
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 */
public class L1752检查数组是否经排序和轮转得到 {

    class Solution {
        /**
         * 作者：Ladidol
         * 描述：从第一个开始不递减的开始，如果能一直不递减到n次，就说明这个可以。
         * 用双倍数组来做。
         */
        public boolean check(int[] nums) {
            int n = nums.length;
            int[] numsNums = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                numsNums[i] = nums[i % n];
            }
//            System.out.println("numsNums = " + Arrays.toString(numsNums));
            for (int i = 0; i < 2 * n - 1; i++) {
                if (numsNums[i + 1] < numsNums[i]) {
                    i++;
                    int cnt = 0;
                    while (i + 1 <= 2 * n - 1 && i <= 2 * n - 1
                            && numsNums[i + 1] >= numsNums[i]) {
                        cnt++;
                        i++;
                    }
                    if (cnt == n - 1) {
//                        System.out.println("true: cnt = " + cnt);
                        return true;
                    } else {
//                        System.out.println("false: cnt = " + cnt);
                        return false;
                    }
                }
            }
            return true;
        }
    }
}