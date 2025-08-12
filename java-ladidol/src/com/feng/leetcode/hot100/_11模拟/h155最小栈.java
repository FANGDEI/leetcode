package com.feng.leetcode.hot100._11模拟;

import com.feng.leetcode.hot100._11模拟.h155最小栈.MinStack.Node;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/12 10:26
 */
public class h155最小栈 {



  class MinStack {

    private Node top;
    private int min = Integer.MAX_VALUE;


    public MinStack() {
    }

    // 每次有新成员入栈的时候，新成员要记住自己之前的最小值就行了，跟那个股票的类似。
    public void push(int val) {
      Node node = new Node();
      node.val = val;
      node.lastMin = min;
      min = Math.min(val, min);
      node.next = top;
      top = node;


    }

    public void pop() {
      min = top.lastMin;
      top = top.next;
    }

    public int top() {
      return top.val;
    }

    public int getMin() {
      return min;
    }

    class Node {
      int val;
      int lastMin;
      Node next;
    }

  }





}
