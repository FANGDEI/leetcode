package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 20:21
 * @description: 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 */
public class L496下一个更大元素I {

    class Solution {
        /**
         * 把num2中更大元素找到，并存入hash表中
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums2.length; i++) {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    map.put(nums2[stack.peek()], nums2[i]);
                    stack.pop();
                }
                stack.push(i);
            }
//            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = map.getOrDefault(nums1[i], -1);
            }
            return nums1;
        }
    }
}
