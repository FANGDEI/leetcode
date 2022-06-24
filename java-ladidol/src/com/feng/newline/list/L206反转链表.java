package com.feng.newline.list;

import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L206反转链表
 * @author: Ladidol
 * @description:
 * @date: 2022/6/24 23:22
 * @version: 1.0
 */
public class L206反转链表 {
    public static void main(String[] args) {

    }

    //双指针法
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            //cur为最右边的节点
            ListNode tmp = cur.next;//保存下一个节点
            cur.next = pre;
            pre = cur;//pre指针移动
            cur = tmp;//cur指针移动
        }

        return pre;
    }
    //变法-递归
    public ListNode reverseList2(ListNode head) {
        //初始化
        return reverseCurrentNode(null,head);
    }
    public ListNode reverseCurrentNode(ListNode pre, ListNode cur){

        if (cur == null){
            return pre;
        }

        ListNode tmp = cur.next;//保存下一个节点
        cur.next = pre;//反转
        pre = cur;//
        cur = tmp;
        return reverseCurrentNode(pre, cur);
    }

    //从后往前递归看球不懂, 我是什么废物啊
    ListNode reverseList3(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;
        //先把每一个都看成是两个节点的链表

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList3(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }





}
