package com.feng.newline.list;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L19删除链表的倒数第N个结点
 * @author: Ladidol
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 思路: 注意是删除倒数第n个节点，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
 *
 * @date: 2022/7/10 15:12
 * @version: 1.0
 */
public class L19删除链表的倒数第N个结点 {


    class L19 {
        //通过一次遍历就能删除倒数第n个节点.
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);

            dummy.next = head;

            ListNode pre = dummy;
            ListNode fast = dummy;
            ListNode slow = dummy;

            //fast先走n步
            while(n-->0){
                fast = fast.next;
            }

            //只要fast不指向null就证明n是小于链表长度的.
            while(fast!=null){//fast逐渐接近空的路上,就是slow接近待删除的节点的过程.
                //保存前置节点pre
                pre = slow;
                slow = slow.next;
                fast = fast.next;

            }
            pre.next = slow.next;

            return dummy.next;
        }
    }
}
