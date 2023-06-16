package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/16 17:03
 * @description: {}
 */
public class 剑指OfferII027回文链表 {


    //有找中点的方法；这里还是通过双端队列来做吧。
    class Solution {
        public boolean isPalindrome(ListNode head) {
            Deque<Integer> deque = new ArrayDeque<>();
            while (head != null) {
                deque.offer(head.val);
                head = head.next;
            }
            while (true) {
                Integer left = deque.pollFirst();
                Integer right = deque.pollLast();
                if (left == null || right == null) {
                    return true;
                }
                if (left != right) {
                    return false;
                }
            }

        }
    }


}
