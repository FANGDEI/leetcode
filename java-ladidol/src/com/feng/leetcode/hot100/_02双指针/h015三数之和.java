package com.feng.leetcode.hot100._02双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h015三数之和 {

    //按道理继续双指针咯
    class Solution {//2022年10月8日14:55:02，在做这一题。 2023年3月1日10:00:14

        /**
         * 参数：[nums]
         * 返回值：java.util.List<java.util.List<java.lang.Integer>>
         * 作者： ladidol
         * 描述：
         * 没做出来：先排序+每一次循环都是对left的双指针步步紧逼+中间left和right指针反复横跳。看高赞的图解就行了。
         * 现在换成 i 和left 和right三个指针来做，注意nums[i]是这里面最小的，为了是三个数加起来为零，nums[i]必须小于等于0。
         */
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            if (n <= 2) return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);//先排序

            int pre = -5001;
            for (int i = 0; i < n - 2; i++) {
                //从每一个左边界i开始
                if (nums[i] > 0) return res;
                if (nums[i] == pre) continue;

                // 初始化中间跳动的指针left
                int left = i + 1;
                // 初始化right有边界
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //去重操作！！！
                        while (left + 1 < right && nums[left] == nums[left + 1]) left++;
                        while (left < right - 1 && nums[right] == nums[right - 1]) right--;


                        //下一个组合判断
                        //这里很细节
                        left++;
                        right--;


                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
                pre = nums[i];//维护pre，对nums[i]进行去重。
            }
            return res;

        }
    }

}
