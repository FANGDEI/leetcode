package com.feng.newline.monotonestack;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.monotonestack
 * @className: L503下一个更大元素II
 * @author: Ladidol
 * @description: 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），返回nums中每个元素的 下一个更大元素 。
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * @date: 2022/9/10 21:12
 * @version: 1.0
 */
public class L503下一个更大元素II {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
//        System.out.println("new Solution().nextGreaterElements() = " + new Solution().nextGreaterElements(nums));
    }


    // 单调栈
    class Solution {
        // 第一感觉没有思路，想不出一个完整的思路
        // 后来发现：原来笨方法就是直接nums*2拼接：这里我用了一个小技巧：通过取余，就可以把答案全部覆盖在res（数组大小为n）中去了。
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            for (int i = 0; i < nums.length * 2; i++) {//循环数组不过就是走两遍nums数组。
                int index = i % nums.length;
                while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[index];
                    stack.pop();
                }
                stack.push(index);
            }

            return res;
        }
    }
}
