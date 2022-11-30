package com.feng.newline.stack_and_queue;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/30 13:57
 * @description: 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * 实现 FreqStack 类:
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 * 示例 1：
 * <p>
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * FreqStack = new FreqStack();
 * freqStack.push (5);//堆栈为 [5]
 * freqStack.push (7);//堆栈是 [5,7]
 * freqStack.push (5);//堆栈是 [5,7,5]
 * freqStack.push (7);//堆栈是 [5,7,5,7]
 * freqStack.push (4);//堆栈是 [5,7,5,7,4]
 * freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
 * freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
 * freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
 * 提示：
 * <p>
 * 0 <= val <= 109
 * push 和 pop 的操作数不大于 2 * 104。
 * 输入保证在调用 pop 之前堆栈中至少有一个元素。
 */
public class L895最大频率栈 {
    //优先级队列+哈希表(不知道为啥就是做不对)，
    //这里每次都查表的，2022年11月30日14:38:28 懂了这里不能每次都查表更新表，因为这里的表里数据更新了，queue中的有些相同元素cnt没更新，可能更多。
    class FreqStack1 {
//        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                if (Objects.equals(map.get(a[1]), map.get(b[1]))) return b[2] - a[2];//index降序排列，取最大值
//                return map.get(b[1]) - map.get(a[1]);//cnt降序，取最大值
//            }
//        });
//        int index = Integer.MIN_VALUE;//index越大越新。
//
//        public void push(int val) {
//            int cnt = map.getOrDefault(val, 0);
//            map.put(val, cnt + 1);//维护个数
//            queue.offer(new int[]{cnt + 1, val, index++});
//        }
//
//        public int pop() {
//            int[] poll = queue.poll();
//            int val = poll[1];
//            map.put(val, map.get(val) - 1);//维护个数
//            return val;
//        }
    }

    //优先级队列+哈希表
    //这里不需要查表，直接根据一次桶，二次桶，三次桶。。。。。最多次桶：说白了就是在每一个个数中排序。
    class FreqStack {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[2] - a[2];//index降序排列，取最大值
                return b[0] - a[0];//降序，取最大值
            }
        });
        int index = Integer.MIN_VALUE;//index越大越新。

        public void push(int val) {
            int cnt = map.getOrDefault(val, 0);
            map.put(val, cnt + 1);//维护个数
            queue.offer(new int[]{cnt + 1, val, index++});
        }

        public int pop() {
            int[] poll = queue.poll();
            int val = poll[1];
            map.put(val, poll[0] - 1);//维护个数
            return val;
        }
    }


}