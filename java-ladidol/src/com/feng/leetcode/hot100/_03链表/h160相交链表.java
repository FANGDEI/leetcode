package com.feng.leetcode.hot100._03链表;


import java.util.HashSet;
import java.util.Set;

public class h160相交链表 {


    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA;
            ListNode B = headB;
            while(A != B){
                // 从头跳到尾
                A = A == null? headB:A.next;
                B = B == null? headA:B.next;
            }
            return A;
        }
    }



}
