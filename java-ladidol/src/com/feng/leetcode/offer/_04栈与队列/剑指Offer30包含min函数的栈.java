package com.feng.leetcode.offer._04栈与队列;

public class 剑指Offer30包含min函数的栈 {


    //用空间换时间，可以用实现一个min栈
    class MinStack {


        /**
         * 让我们实现栈，我们就手写个链表就好啦，每个节点加一个额外属性：当前最小值。
         * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/discussion/comments/259777
         *
         */
        private Node head;

        public MinStack() {

        }

        public void push(int x) {

            if (head == null)
                head = new Node(x, x, null);
            else
                head = new Node(x, Math.min(head.min, x), head);//更新head，就是栈顶
        }

        public void pop() {

            head = head.next;
        }

        public int top() {

            return head.val;
        }

        public int min() {

            return head.min;
        }

        private class Node {

            int val;
            int min;
            Node next;

            public Node(int val, int min, Node next) {

                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
