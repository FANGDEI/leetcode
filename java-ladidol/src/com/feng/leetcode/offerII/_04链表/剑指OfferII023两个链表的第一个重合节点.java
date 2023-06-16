package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/15 16:55
 * @description: {}
 */
public class 剑指OfferII023两个链表的第一个重合节点 {


    //代码随想录的解法就是最优秀的。
    public class Solution {
        /**
         * 先得到size差值，然后从短的list长度开始
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int sizeA = 0;
            int sizeB = 0;
            ListNode nodeA = headA;
            ListNode nodeB = headB;


            while (nodeA != null) {
                sizeA++;
                nodeA = nodeA.next;
            }

            while (nodeB != null) {
                sizeB++;
                nodeB = nodeB.next;
            }

            int gap = Math.abs(sizeA-sizeB);
            if (sizeA>sizeB){
                while (gap-->0){
                    headA = headA.next;
                }

            }else{
                while (gap-->0){
                    headB = headB.next;
                }
            }

            while (headA!=null){
                if (headA==headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;

        }
    }

}
