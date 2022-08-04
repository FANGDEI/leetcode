package com.dyw.leetcode.simple.list;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-08-04-11:46
 *
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 *
 */
@SuppressWarnings("all")
public class L160相交链表 {
    public static void main(String[] args) {

    }

    /**
     * hash表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tail1 = headA;
        ListNode tail2 = headB;
        while (tail1!=null){
            set.add(tail1);
            tail1 = tail1.next;
        }

        while (tail2!=null){
            if (set.contains(tail2)){
                return tail2;
            }
            tail2 = tail2.next;
        }
        return null;
    }
}
