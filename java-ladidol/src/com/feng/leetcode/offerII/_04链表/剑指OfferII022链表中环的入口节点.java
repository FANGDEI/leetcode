package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 17:23
 * @description: {}
 */
public class 剑指OfferII022链表中环的入口节点 {


    // 用个map就行，非要卷卷卷，另一个思路就是，快慢指针走到环里面相遇，
    // 然后慢指针从头再来，快指针在环里面等待再次相遇
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode ptr = head;
            Set<ListNode> visited = new HashSet<>();
            while (ptr != null) {
                if (visited.contains(ptr)) {
                    return ptr;
                } else {
                    visited.add(ptr);
                }
                ptr = ptr.next;
            }
            return null;
        }
    }

}
