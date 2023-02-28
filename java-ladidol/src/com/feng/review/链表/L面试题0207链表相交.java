package com.feng.review.链表;

import com.feng.newline.list.ListNode;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L面试题0207链表相交
 * @author: Ladidol
 * @description: 题目: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 *
 * 解题:
 * 简单来说，就是求两个链表交点节点的指针。 这里同学们要注意，交点不是数值相等，而是指针相等。
 * 思路:
 * @date: 2023年2月22日21:01:32
 * @version: 1.0
 */
public class L面试题0207链表相交 {


    /**
     * 法子一: 不难发现,如果是有相交的话,至于相交点后面的全部节点都是一致的,我们不妨把短list移到后面并与长list对齐尾部.这样后面至于要遍历一遍同起点就能找到是不是有相交线.
     * @param:
     * @return:
     * @Author: Ladidol
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0;
            int lenB = 0;

            ListNode curA = headA;
            ListNode curB = headB;
            while(curA!=null){
                //求A的长度
                lenA ++;
                curA = curA.next;
            }
            while(curB!=null){
                lenB ++;
                curB = curB.next;
            }
            //为了方便这里就使headA为最长的链表,lenA为长度
            if (lenA<lenB){
                ListNode tmp = headA;
                headA = headB;
                headB = tmp;
                int tmpLen = lenA;
                lenA = lenB;
                lenB = tmpLen;
            }
            //再次初始化curA和curB
            curA = headA;
            curB = headB;
            //比较长的headA先移动到同一起跑线
            int gap = lenA - lenB;
            while(gap-->0){
                curA = curA.next;
            }
            //现在已经对齐尾部了
            while(curA!=null){
                if (curA == curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }

    /**
     * 不难发现这是一个比较浪漫的解法
     * @param:
     * @return:
     * @Author: Ladidol
     */
    /*提示: 这也太强了吧。 就是把握住一定会有共同的链表，以及相加后长度相等且固定位置末端比相同*/
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode curA = headA;
            ListNode curB = headB;
            // 要么相遇即节点相等，要么都为空即无缘无分，最终都能跳出感情的死循环。
            while(curA != curB){
                // 两人以相同的速度（一次一步）沿着各自的路径走，当走完各自的路时，再“跳”至对方的路上。（起点平齐速度相同，终点即为相遇点）
                curA = (curA == null? headB:curA.next);
                curB = (curB == null? headA:curB.next);
            }
            return curA;

        }
    }



}
