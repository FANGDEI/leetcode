package com.feng.newline.month._9_datastructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

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


    // 2022年9月22日23:59:05今天再来重新做一下。

    // 方法一：优先队列（堆）
    // 根据题意，容易想到优先队列（大根堆），同时为了确保滑动窗口的大小合法性，我们以二元组 (idx, nums[idx])(idx,nums[idx]) 的形式进行入队。
    //    当下标达到首个滑动窗口的右端点后，每次尝试从优先队列（大根堆）中取出最大值（若堆顶元素的下标小于当前滑动窗口左端点时，则丢弃该元素）。
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 只在取出的时候判断它是不是符合在这个范围里面
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);//二元组 0：下标 1：数值。
            int[] res = new int[nums.length - k + 1];//答案数组大小和k的关系
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                queue.offer(new int[]{i, nums[i]});
                if (i >= k - 1) {
                    while (queue.peek()[0] < i - k + 1) queue.poll();//丢去不在框框里面的元素。
                    res[index++] = queue.peek()[1];
                }
            }
            return res;
        }
    }
    // ↑有点细节呜呜呜呜

    // 方法二：单调栈，emm感觉和平常的单调队列有了点不一样的地方了，但是依旧体现了单调栈亘古不变的维护方式：while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) d.pollLast();
    // RMQ求区间最值问题，最常用的一个方法就是用单调栈：
    // 1. 先保证单调栈中的元素都是可能成为后面窗口中的最大值：从栈底到栈口递减（栈尾元素一定比当前元素要大）
    // 2. 再保证栈底元素能不能胜任当前窗口的最大值（若栈底元素的下标小于当前滑动窗口左端点时，则丢弃该元素）
    // 做完你会发现：单调队列的做法其实和优先级队列很相似，“我们的单调栈其实就是优先级队列（没有当前元素nums[i]的后面）”。
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[nums.length - k + 1];
            // 单调栈中存放的是下标，方便快速寻找它在原数组中的位置。
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    //说明，更新更大的nums[i]会替代以前的一定不可能成为max的元素。
                    deque.pollLast();//弹出；
                }
                deque.addLast(i);
                if (i >= k - 1) {
                    while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                        deque.pollFirst();//栈底的过期，丢掉。
                    }
                    res[i - k + 1] = nums[deque.peekFirst()];//取栈底下标，再从数组中找到值。
                }
            }
            return res;
        }
    }


    // 麻了，下面这我两个月前做的单调队列，我看不懂了呜呜呜呜。

    //???单调队列???头结点一定是下标最小的捏.
    //对于窗口里的元素{2, 3, 5, 1 ,4}，单调队列里只维护{5, 4} 就够了，保持单调队列里单调递减，此时队列出口元素就是窗口里最大元素。
    //此时大家应该怀疑单调队列里维护着{5, 4} 怎么配合窗口经行滑动呢？

    /**
     * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
     * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
     */

    static class Solution3 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();//单调队列-递减.
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                //遍历途中维护一下单调队列
                // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
                // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出    头结点一定是下标最小的捏.
                if (!stack.isEmpty() && stack.peek() < i - k + 1) {
                    stack.poll();
                }
                // 2.既然是单调，就要保证每次放进去的数字要不大于末尾，否则也弹出
                while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                    stack.pollLast();
                }
                stack.offer(i);//将下标放入
                if (i >= k - 1) {
                    res[index++] = nums[stack.peek()];//这里不用清理最大值的原因是, 可能这个最大值也是后面的最大值, 他要多用几次.
//                    res[index++] = nums[monotoneDeque.pop()];//×
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {1,3,1,2,0,5};
        int[] ints = solution3.maxSlidingWindow(nums, 3);
        System.out.println("ints = " + Arrays.toString(ints));
    }

}
