package com.feng.newline.list;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L203移除链表元素
 * @author: Ladidol
 * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 有两种方法来进行链表删除操作:
 * 1. 直接使用原来的链表来进行删除操作。头结点后后面节点删除方式不一样
 * 2. 设置一个虚拟头结点在进行删除操作。节点都是有前一个节点来删除
 *
 * @date: 2022/6/20 21:47
 * @version: 1.0
 */

class L203移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        //弄一个虚拟头结点来删除操作
        ListNode dummy = new ListNode(-1, head);//
        ListNode pre = dummy;
        ListNode cur = dummy.next;//这里使用两个节点来操作的pre和cur, 也可以只用cur来, 不过是要预知cur.next.val是不是满足if条件和while条件
        while(cur!=null){
            if (cur.val == val){
                //把该节点给删除掉
                pre.next = cur.next;
            }else {
                //移动前置节点
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    //单节点操作
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public ListNode 不添加虚拟节点(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


}
