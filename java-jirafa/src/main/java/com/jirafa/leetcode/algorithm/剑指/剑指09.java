package com.jirafa.leetcode.algorithm.剑指;

import java.util.Deque;
import java.util.LinkedList;

public class 剑指09 {
    private Deque<Integer> inQueue;
    private Deque<Integer> outQueue;

    public 剑指09() {
        inQueue=new LinkedList<>();
        outQueue=new LinkedList<>();
    }

    public void appendTail(int value) {
        inQueue.push(value);
    }

    public int deleteHead() {
        int result;
        if(outQueue.isEmpty()){
            if(!convert())
                return -1;
        }
        result=outQueue.pop();
        return result;
    }

    public boolean convert() {
        while (!inQueue.isEmpty()){
            outQueue.push(inQueue.pop());
        }
        return !outQueue.isEmpty();
    }
}
