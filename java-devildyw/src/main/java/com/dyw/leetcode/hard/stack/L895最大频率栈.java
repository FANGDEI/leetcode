package com.dyw.leetcode.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-11-30-12:29
 */
@SuppressWarnings("all")
public class L895最大频率栈 {

    /**
     * 每次需要优先弹出频率最大的元素，如果频率最大元素有多个，则优先弹出靠近栈顶的元素
     *
     * 于是我们可以把栈序列分解为多个频率不同的栈序列，每个栈维护同一频率的元素。
     */
    class FreqStack {
        HashMap<Integer,Integer> freq; //记录一个元素以及它出现的频率
        HashMap<Integer, Deque<Integer>> group; //记录不同频率对应的栈
        private int maxFreq;//记录最大频率

        //初始化
        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            //当有元素push 首先记录他出现的频率
            freq.put(val,freq.getOrDefault(val,0)+1);
            //随之将其加入对应频率的栈序列中 如果没有栈序列先创建栈序列然后将元素加入
            group.putIfAbsent(freq.get(val),new ArrayDeque<>());
            group.get(freq.get(val)).push(val);
            //最后更新最大频率
            maxFreq = Math.max(maxFreq,freq.get(val));
        }

        public int pop() {
            //当pop时 首先取出最大频率对应的栈序列的最顶端的值
            int val = group.get(maxFreq).peek();
            //然后将该值对应的频率减一
            freq.put(val,freq.get(val)-1);
            //如果栈序列为空了 则更新最大频率
            if (group.get(maxFreq).isEmpty()){
                maxFreq--;
            }
            return val;
        }
    }
}
