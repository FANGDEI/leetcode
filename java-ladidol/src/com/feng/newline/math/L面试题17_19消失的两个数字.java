package com.feng.newline.math;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L面试题17_19消失的两个数字
 * @author: Ladidol
 * @description: 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 * <p>
 * nums.length <=30000
 * @date: 2022/9/26 21:57
 * @version: 1.0
 */
public class L面试题17_19消失的两个数字 {


    // 数学，等差数列之和。
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;//没消失之前该有的长度。
            int cur = n * (n + 1) / 2;//等差数列之和。(1-n的和)
            for (int num : nums) {
                cur -= num;
            }
            int twoSum = cur;
            int twoMid = cur / 2;
            cur = twoMid * (twoMid + 1) / 2;//只包含前面一个消失数的原有等差数列之和。(1-towMid的和)

            for (int num : nums) {
                if (num <= twoMid) cur -= num;
            }

            int first = cur;
            int second = twoSum - first;
            return new int[]{first, second};
        }
    }
}
