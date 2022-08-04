package com.feng.newline.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L239滑动窗口最大值
 * @author: Ladidol
 * @description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @date: 2022/7/28 14:48
 * @version: 1.0
 */
public class L239滑动窗口最大值 {


    //???单调队列???头结点一定是下标最小的捏.
    //对于窗口里的元素{2, 3, 5, 1 ,4}，单调队列里只维护{5, 4} 就够了，保持单调队列里单调递减，此时队列出口元素就是窗口里最大元素。
    //此时大家应该怀疑单调队列里维护着{5, 4} 怎么配合窗口经行滑动呢？

    /**
     * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
     * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
     */

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> monotoneDeque = new ArrayDeque<>();//单调队列-递减.//ArrayDeque删除要快一些.
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                //遍历途中维护一下单调队列
                // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
                // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出    头结点一定是下标最小的捏.
                if (!monotoneDeque.isEmpty() && monotoneDeque.peek() < i - k + 1) {
                    monotoneDeque.poll();
                }
                // 2.既然是单调，就要保证每次放进去的数字要不大于末尾，否则也弹出
                while (!monotoneDeque.isEmpty() && nums[monotoneDeque.peekLast()] < nums[i]) {
                    monotoneDeque.pollLast();
                }
                monotoneDeque.offer(i);//将下标放入
                if (i >= k - 1) {
                    res[index++] = nums[monotoneDeque.peek()];//这里不用清理最大值的原因是, 可能这个最大值也是后面的最大值, 他要多用几次.
//                    res[index++] = nums[monotoneDeque.pop()];//×
                }
            }
            return res;
        }
    }
}
