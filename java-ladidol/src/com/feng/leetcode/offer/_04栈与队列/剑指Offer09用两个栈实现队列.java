package com.feng.leetcode.offer._04栈与队列;

import java.util.Stack;

public class 剑指Offer09用两个栈实现队列 {


    //就是用两个栈来模拟
    class CQueue {

        Stack<Integer> into = new Stack<>();
        Stack<Integer> out = new Stack<>();


        public void appendTail(int value) {
            into.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()) {
                if (into.isEmpty()) return -1;//为空判断。
                into2();//更新此时为空的out数组
            }
            return out.pop();
        }

        /**
         * 从into放到out中去。
         */
        private void into2() {
            while (!into.isEmpty()) {
                out.push(into.pop());
            }
        }


    }


}
