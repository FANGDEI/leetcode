package com.feng.leetcode.hot100._02双指针;

import java.util.Stack;

public class h042接雨水 {



    //单调栈
    class Solution {
        /**
         * 解：先用单调栈来做，需要三个指针，底和两边的高
         * 维护一个单调递减的栈，栈顶是底，栈顶第二个元素师左边的高，当前大于栈底的元素为右边的高
         *
         * @param h
         * @return
         */
        public int trap(int[] h) {
            //维护1一个单调栈，从栈底到栈顶是单调递减的，只有小于栈顶peek元素，才会push压栈！
            Stack<Integer> stack = new Stack<>();
            int n = h.length;
            stack.push(0);//初始化左边的高

            int ans = 0;

            for (int i = 1; i < n; i++) {
                int right = i;
                while (!stack.isEmpty() && h[stack.peek()] < h[right]) {
                    int di = stack.pop();
                    if (stack.isEmpty()) {//排除不能存水的右挡板right最高，切最后一种情况
                        continue;
                    }
                    int left = stack.peek();
                    ans += (Math.min(h[left], h[right]) - h[di]) * (right - left - 1);
                }
                stack.push(right);
            }
            return ans;
        }
    }



}
