package com.feng.draft.template.rangesum;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.rangesum
 * @className: BinaryIndexedTree
 * @author: Ladidol
 * @description:
 * @date: 2022/7/25 23:08
 * @version: 1.0
 */
public class BinaryIndexedTree {


    class NumArray {
        // 累加和
        int[] sums;
        // 更新后数组
        int[] nums;

        public NumArray(int[] nums) {
            // 原数组长度+1, +1的原因是计算lowbit时,使用下标0会进入死循环
            this.sums = new int[nums.length + 1];
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                // 初始化累加和数组
                insert(i, nums[i]);
            }
        }

        /*===================下面是模板==============================*/
        /**
         * 插入数字,初始化
         */
        private void insert(int index, int val) {
            // 下标+1
            int x = index + 1;
            while (x < sums.length) {
                sums[x] = sums[x] + val;
                x += lowBit(x);
            }
        }
        /**
         * 查询树状数组
         */
        public int query(int x) {
            int s = 0;
            while (x != 0) {
                s += sums[x];
                x -= lowBit(x);
            }
            return s;
        }

        /**
         * 计算lowBit
         */
        private int lowBit(int x) {
            return x & (-x);
        }

        /**
         * 更新数组以及累加和
         */
        public void update(int index, int val) {
            int x = index + 1;
            while (x < sums.length) {
                // 减去之前nums[index]的值, 加上新的值
                sums[x] = sums[x] - nums[index] + val;
                x += lowBit(x);
            }
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }

    }
}