package com.feng.leetcode.offer._06查找算法;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/22 12:02
 * @description: {}
 */
public class 剑指Offer53_I在排序数组中查找数字I {


    //用二分查找
    class Solution {
        /**
         * 二分单边 + 线性扫描
         * 一个朴素的想法是，找到目标值 targettargettarget 「首次」出现或者「最后」出现的下标，然后「往后」或者「往前」进行数量统计。
         * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solutions/878591/gong-shui-san-xie-liang-chong-er-fen-ton-3epx/?envType=study-plan-v2&envId=coding-interviews
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int left = lower_bound(nums, 0, nums.length - 1, target);
            int ans = 0;
            while (left <= nums.length - 1 && nums[left] == target) {
                ans++;
                left++;
            }
            return ans;

        }

        int lower_bound(int[] nums, int l, int r, int value) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] >= value)
                    r = mid;
                else
                    l = mid + 1;
            }
            return l; // 返回的是出现value的坐标范围[l,r)的l。
        }
    }


}
