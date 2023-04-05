package top.dyw.leetcode.hard.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 *
 * @author Devil
 * @since 2022-09-18-11:27
 */
@SuppressWarnings("all")
public class L239滑动窗口最大值 {
    public static void main(String[] args) {
        int[] ints = new L239滑动窗口最大值().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
        System.out.println();
    }

    /**
     * 暴力解法 回报超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0; //left
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        int index = 0;
        for (int j = 0; j < length; j++) {
//            System.out.println("j:"+j+" "+"i:"+i);
            if ((j - i + 1) == k) {
                int max = -9999;
                for (int n = i; n <= j; n++) {
                    max = Math.max(max, nums[n]);
                }
                ans[index++] = max;
                i++;
            }
        }
        return ans;
    }

    /**
     * 单调队列 即在k个的范围内 单调队列只会保证递减的顺序 这样我们获取对头元素时总是最大值 并且不需要像优先队列一样去维护一个顺序关系 我们只需要记录k范围数组内的递减顺序
     * 比如 1 2 5 3 4 我们只记录 5 4
     *
     * 这样我们滑动时需要移除最左边的元素此时需要调用队列的移除方法 并且判断该元素是否在队列中
     *
     * 并且滑动时还需要加入最右边的元素 如果最右边的元素比队列中的队尾元素大 那么因为保证递减 所以需要将队列内所有比该元素小的移除 再将其填入
     *
     * 依照这个规律我们就看也写出一个自定义的单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow01(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前k的元素放入队列 先记录前k个
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        //开始滑动
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除时判断该元素是否放入队列
            myQueue.poll(nums[i-k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        /**
         * 弹出元素的时候，比较当前要弹出的数值是否等于队列出口的数值 如果相等则弹出
         * 同时判断队列当前是否为空
         *
         * @param val
         */
        public void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        /**
         * 添加元素时，如果要添加的元素大于入口处的额元素，就将入口元素弹出
         * 保证队列单调递减
         * 比如此时队列元素 3 1 2 将要入队，比 1 大，所以 1 弹出，此时队列为 3，2
         *
         * @param val
         */
        public void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        public int peek() {
            return deque.peek();
        }
    }
}
