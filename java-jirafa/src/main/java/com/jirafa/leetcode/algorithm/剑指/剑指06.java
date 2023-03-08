package com.jirafa.leetcode.algorithm.剑指;

import com.jirafa.leetcode.utils.ListNode;

import java.util.LinkedList;

public class 剑指06 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> nums = new LinkedList<>();
        while (head!=null) {
            nums.push(head.val);
            System.out.println(head.val);
            head=head.next;
        }
        int[] res = new int[nums.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=nums.pop();
        }
        return res;
    }
}
