package com.feng.leetcode.offer._05模拟;

import java.util.Stack;

public class 剑指Offer31栈的压入弹出序列 {

    /**
     * pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     */
    class Solution {
        /**
         * 就是用一个stack栈来模拟一下入栈和出栈，这里popped就是其中一个出栈可能
         *
         * @param pushed
         * @param popped
         * @return
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0, j = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
