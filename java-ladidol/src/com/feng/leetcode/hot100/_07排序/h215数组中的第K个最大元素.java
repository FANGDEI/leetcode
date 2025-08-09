package com.feng.leetcode.hot100._07排序;

import static com.feng.leetcode.hot100._00其他.QuickSortTemp.*;

public class h215数组中的第K个最大元素 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int pivot = partition(nums, left, right);
                if (pivot + 1 == k) {
                    return nums[pivot];
                } else if (pivot + 1 < k) {
                    // 第 k 大元素在右半部分
                    left = pivot + 1;
                } else {
                    // 第 k 大元素在左半部分
                    right = pivot - 1;
                }
            }
            return 0;
        }

        public int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int i = left;
            int j = right;
            while (i < j) {

                while (i < j && nums[j] <= pivot) {
                    j--;
                }
                nums[i] = nums[j]; // 此时j已经表示前半部分了。

                while (i < j && nums[i] >= pivot) {
                    i++;
                }
                nums[j] = nums[i]; // 此时i已经表示后半部分了
            }
            nums[i] = pivot;
            return i;
        }

    }


}
