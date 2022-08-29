package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L793阶乘函数后K个零
 * @author: Ladidol
 * @description:  f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
 * <p>
 * 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
 * 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
 * 示例 1：
 * <p>
 * 输入：k = 0
 * 输出：5
 * 解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
 * 示例 2：
 * <p>
 * 输入：k = 5
 * 输出：0
 * 解释：没有匹配到这样的 x!，符合 k = 5 的条件。
 * 示例 3:
 * 输入: k = 3
 * 输出: 5
 * @date: 2022/8/28 12:15
 * @version: 1.0 每日一题 超，看不懂https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/solution/jie-cheng-han-shu-hou-kge-ling-by-capita-3qq1/
 */
public class L793阶乘函数后K个零 {
    class Solution {
        public int preimageSizeFZF(int k) {
            //返回y - x
            return (int) (calMinKZero(k + 1) - calMinKZero(k));
        }

        //二分法计算第一个x,使得 f(x) = k
        public long calMinKZero(int k) {
            long left = 0L;
            long right = 5L * k;//直接用long.max.value就能过
            long ans = right;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (calZero(mid) >= k) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
        //计算末尾0
        public int calZero(long n) {
            int ans = 0;
            while (n != 0) {
                n = n / 5;
                ans += n;
            }
            return ans;
        }
    }
}
