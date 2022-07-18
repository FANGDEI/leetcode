package com.feng.newline.deque;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.deque
 * @className: L735行星碰撞
 * @author: Ladidol
 * @description: 若当前行星是大于0的，直接入栈。
 * 若当前行星是小于0的，我们考虑在什么情况下会发生碰撞，并且判断当前行星是否存活
 * <p>
 * 若栈为空，直接入栈
 * 若栈顶元素小于0，表示栈内元素均向左，直接入栈
 * 若栈顶元素大于0，我们需要和当前行星做判断：
 * 绝对值相等，均爆炸
 * 栈顶元素大于当前行星绝对值，当前行星爆炸
 * 栈顶元素小于当前行星绝对值，栈顶元素爆炸，然后接着判断下一个栈顶元素。
 * @date: 2022/7/13 9:36
 * @version: 1.0
 */
//每日一题2022年7月13日10:16:49
public class L735行星碰撞 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, -2, -3};
        int[] nums = {-2,-2,-1,-2};
        System.out.println("new Solution().asteroidCollision() = " + Arrays.toString(new Solution2().asteroidCollision(nums)));
    }

    //deque = [5, 4, 3, 2, 1] 队列原本的样子.
    //new Solution().asteroidCollision() = [1, 2, 3, 4, 5]


    //模拟栈, 栈顶就是队列头部,对列是一点一点往后面退.
    static class Solution1 {
        public int[] asteroidCollision(int[] asteroids) {

            Deque<Integer> stack = new ArrayDeque<>();//2022/7/13 LinkedList和这个ArrayDeque的区别是.似乎没有区别

            for (int asteroid : asteroids) {
                if (asteroid > 0) {
                    stack.addFirst(asteroid);//2022/7/13 push 和addLast 和addFirst有什么区别.push在队列首部
//                    deque.push(asteroid);
                } else {
                    Boolean alive = true;
                    while (alive && !stack.isEmpty() && stack.peek() > 0) {
                        alive = stack.peek() < Math.abs(asteroid);
                        if (stack.peek() <= Math.abs(asteroid)) {
                            stack.pop();
                        }
                    }
                    if (alive) {
                        stack.push(asteroid);
                    }
                }
            }
            int n = stack.size();
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {//注意这里每次poll一下,size都会变小的,size可以用n来代替
                ans[i] = stack.pollLast();
//                ans[i++] = stack.pop();//pop和poll是一样的都是从前面开始移除.
//                ans[i++] = stack.poll();
            }
            return ans;
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            //大于0 直接入栈
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                //是否存活
                boolean alive = true;
                //当前元素存活 并且栈不是空 并且栈顶元素大于0
                while (alive && !stack.isEmpty() && stack.peek() > 0) {
                    //只有栈顶元素小于当前元素的绝对值，才会存活
                    alive = stack.peek() < Math.abs(asteroid);
                    //栈顶元素爆炸（出栈）
                    if (stack.peek() <= Math.abs(asteroid)) {
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(asteroid);
                }
            }
        }
        //结果输出
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollLast();
        }
        return ans;
    }

    //分界线: 下面是另一种魔力思路, 当然都是用栈来做.

    /**
     * 撞得上, 进栈待撞.
     * 撞没了.
     * 剩下的的都是答案.
     *
     * 提示负数就是往左边走.
     *
     *[-2,-2,-1,-2]
     * @param:
     * @return:
     * @Author: Ladidol
     */
    static class Solution2 {
        public int[] asteroidCollision(int[] asteroids) {
//            Stack<Integer> stack = new Stack<>();//什么慢速stack
            Deque<Integer> stack = new ArrayDeque<>();
            for (int asteroid : asteroids) {
                //栈顶会撞没的:当前是负数, 栈顶体积小的正数.新进来开干(提出相等相消的情况.)
                while(asteroid<0&&!stack.isEmpty()&&(Math.abs(asteroid)>Math.abs(stack.peek())&&stack.peek()>0)){
                    stack.pop();
                }
                //栈为空,方向相同,或者背向而行.
                if (stack.isEmpty()||stack.peek()*asteroid>0||(stack.peek()<0&&asteroid>0)){
                    stack.push(asteroid);
                }else if (Math.abs(asteroid)==Math.abs(stack.peek())){
                    stack.pop();
                }
            }

            int[] ans = new int[stack.size()];
            int i = ans.length-1;
            while (!stack.isEmpty()) {
                ans[i--] = stack.pop();
            }
            return ans;

        }
    }






}


