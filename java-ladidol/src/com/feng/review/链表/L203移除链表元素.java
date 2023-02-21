package com.feng.review.链表;

import com.feng.newline.list.ListNode;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L203移除链表元素
 * @author: Ladidol
 * @description:
 * @date: 2023年2月21日08:32:28
 * @version: 1.0
 */

class L203移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //弄一个虚拟头结点来删除操作
        ListNode dummy = new ListNode(-1, head);//
        ListNode pre = dummy;
        ListNode cur = dummy.next;//这里使用两个节点来操作的pre和cur, 也可以只用cur来, 不过是要预知cur.next.val是不是满足if条件和while条件
        while (cur != null) {
            if (cur.val == val) {
                //把该节点给删除掉
                pre.next = cur.next;
            } else {
                //移动前置节点
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return head;
            ListNode dumpNode = new ListNode(-1);
            ListNode pre = dumpNode;
            ListNode cur = head;
            dumpNode.next = head;
            while (cur != null) {
                if (cur.val == val){
                    pre.next = cur.next;
                }else{
                    pre = pre.next;
                }
                cur = cur.next;

            }
            return dumpNode.next;
        }
    }


}
