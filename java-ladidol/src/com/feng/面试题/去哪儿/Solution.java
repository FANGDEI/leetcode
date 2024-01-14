package com.feng.面试题.去哪儿;

import com.feng.newline.list.ListNode;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n    int整型 数组长度
     * @param nums int整型一维数组 数组
     * @return int整型一维数组
     */
    public int[] findQ(int n, int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            ans.add(nums[i]);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < n; i++) {
            res[n - i - 1] = ans.get(i);
        }
        return res;
    }


    public int find(int n, int target, int[] nums) {
        // write code here
        int left = 0;
        int right = n - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return res == -1 ? n + 1 : res + 1;


    }

    public int lengthL(ListNode head) {
        return 0;

    }
}