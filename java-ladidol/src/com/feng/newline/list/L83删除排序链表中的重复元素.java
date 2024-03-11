package com.feng.newline.list;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/13 22:47
 * @description: {}
 */
public class L83删除排序链表中的重复元素 {


    //先做一下原list有排序的情况
    class Solution11 {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode cur = head;

            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    //这题的变形，如果原list没有排序，就需要双层循环了
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode cur = head;

            while (cur != null) {
                //对每一个节点进行判断
                ListNode tmp = cur;
                while (tmp.next != null) {
                    if (cur.val == tmp.next.val) {
                        tmp.next = tmp.next.next;
                    } else {
                        tmp = tmp.next;
                    }
                }
                cur = cur.next;
            }
            return head;
        }
    }


}
