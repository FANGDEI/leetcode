package top.dyw.leetcode.Hot100;

import java.util.HashSet;

public class L41缺失的第一个正数 {
    // 哈希表 不太符合题目要求的O(1)空间复杂度
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        // 从1开始
        int result = 1;
        while (true) {
            if (set.contains(result)) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
    // 原地哈希 O(1)空间复杂度
    public int firstMissingPositiveO1(int[] nums) {
        int n = nums.length;
        // 利用数组原地hash
        for (int i=0; i<n; i++) {
            // 循环 因为交换后的当前i位置可能仍然需要处理 最后的条件则是防止死循环
            while (nums[i]>0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        // 交换后 每个正整数应该都在起下标位置了 数组的下标除了0号索引外应该都是正整数
        for (int i=0; i<n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        // 如果都对齐了那就是n+1
        return n+1;
    }

    public void swap(int[] nums, int i, int target) {
        int temp = nums[i];
        nums[i] = nums[target];
        nums[target] = temp;
    }
}
