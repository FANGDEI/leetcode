package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/04/18 17:41
 **/
@SuppressWarnings("all")
public class O59I滑动窗口的最大值 {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0||k==0) return new int[0];
        //队列用来维护此时滑动窗口内的最大值 单调递减
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        //分为两个阶段 一 窗口成型阶段：窗口由空到满； 二 窗口移动阶段: 窗口成型后，窗口开始移动将左边界元素剔除，右边界新元素加入
        for (int right = 0,left = 1-k; right < nums.length; right++,left++) {
            //left 大于0 代表该窗口已经有k个元素了 需要移动才能装下下一个
            if (left>0&&deque.peekFirst()==nums[left-1]){
                deque.removeFirst(); //如果此时窗口要剔除的元素就是队首元素则队首元素也出队，代表当前窗口最大值被剔除
            }
            //单调队列，保持deque递减
            while (!deque.isEmpty()&&deque.peekLast()<nums[right]){
                deque.removeLast();
            }
            //新增元素
            deque.addLast(nums[right]);
            //窗口成型后 记录窗口最大值 就是队列的队首元素
            if (left>=0){
                res[left] = deque.peekFirst();
            }
        }
        return res;
    }
}
