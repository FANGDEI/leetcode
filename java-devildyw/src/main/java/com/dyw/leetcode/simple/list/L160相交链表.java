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
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    /**
     * 指针对齐法
     *
     * 将两个链表的末尾对其 以相同长度开始遍历 比较遍历途中的节点是否相等 取第一个相等节点作为相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;
        //计算两个链表的长度
        while (curA!=null){
            lenA++;
            curA = curA.next;
        }

        while (curB!=null){
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        //让curA为最长链表的头，lenA为其长度
        if (lenB>lenA){
            int temLen = lenA;
            lenA = lenB;
            lenB = temLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }

        //求出长度差
        int gap = lenA - lenB;

        //让curA和curB在同一起点上（末尾位置对其）

        while (gap-->0){
            curA = curA.next;
        }

        //比哪里curA 和 curB，遇到相同直接返回
        while (curA!=null){
            if (curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
