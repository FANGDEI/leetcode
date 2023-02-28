package com.feng.review.链表;


import com.feng.newline.list.ListNode;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L19删除链表的倒数第N个结点
 * @author: Ladidol
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 思路: 注意是删除倒数第n个节点，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
 * @date: 2023年2月22日20:59:30
 * @version: 1.0
 */
public class L19删除链表的倒数第N个结点 {

    //再复习一下，这里用之遍历一次的方法，之前廖dq老师教给我们的方法
    //双指针
    class Solution {//2022年10月18日13:45:19复习。2023年2月22日21:00:42review

        /**
         * 参数：[head, n]
         * 返回值：com.feng.newline.list.ListNode
         * 作者： ladidol
         * 描述：
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            while (n >= 0) {
                n--;
                fast = fast.next;
            }
            //这里的slow代表的删除节点前一个元素。
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }


}
