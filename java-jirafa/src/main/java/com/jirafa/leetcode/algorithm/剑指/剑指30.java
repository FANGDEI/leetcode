package com.jirafa.leetcode.algorithm.剑指;

import java.util.LinkedList;

public class 剑指30 {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public 剑指30() {
        stack=new LinkedList<Integer>();
        minStack=new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if(minStack.peek()>=x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if(pop.equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        System.out.println(minStack.toString());
        return minStack.peek();
    }
}
