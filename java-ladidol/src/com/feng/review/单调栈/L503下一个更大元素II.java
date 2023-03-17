package com.feng.review.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/16 20:40
 * @description: {}
 */
public class L503下一个更大元素II {

    class Solution {
        /**
         * 循环数组，就直接双倍法就行了
         *
         * @param nums
         * @return
         */
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int n = nums.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            for (int i = 0; i < n * 2; i++) {
                while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[i % n];
                    stack.pop();
                }
                stack.push(i % n);
            }
//            System.out.println("stack = " + stack);
            //不这样做的原因就是它里面存了一些第二数组中的元素，我们就用Arrays.fill吧。
//            while (!stack.isEmpty()) {
//                res[stack.pop()] = -1;
//            }
            return res;
        }
    }
}
