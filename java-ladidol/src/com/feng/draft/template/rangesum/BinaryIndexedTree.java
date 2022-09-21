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


    //浓缩版
    /*===================下面是模板==============================*/
    class NumArray {
        int n;//数组大小，这里就需要自定义了！
        // 树状数组
        int[] tree = new int[n];
        // 修改后的数组存放
        int[] nums;


        /**
         * 计算lowBit
         */
        int lowbit(int x) {
            return x & -x;
        }
        /**
         * 查询树状数组
         */
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        /**
         * 在x = index+1处加入 add 差值。(如果index取不到0，就可以直接x = index)
         */
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tree[i] += u;
            }
        }



        /**
         * 初始化树状数组
         */
        public NumArray(int[] _nums) {
            nums = _nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                // 原数组长度+1, +1的原因是计算lowbit时,使用下标0会进入死循环
                add(i + 1, nums[i]);
            }
        }

        /**
         * 更新数组以及累加和
         */
        public void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        /**
         * 求区间和
         */
        public int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
    }
}
