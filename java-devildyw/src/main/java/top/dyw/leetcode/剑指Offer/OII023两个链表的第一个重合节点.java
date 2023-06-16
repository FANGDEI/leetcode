package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/13 19:37
 **/
@SuppressWarnings("all")
public class OII023两个链表的第一个重合节点 {

    public static void main(String[] args) {

    }

    /**
     * 两个链表的第一个重合节点
     * @param headA
     * @param headB
     * @return 重合节点
     *  根据脑海里面的图来理解
     *  1. 如果两个链表有重合节点，那么curA和curB一定会在重合节点处相遇
     *  2. 如果两个链表没有重合节点，那么curA和curB一定会在各自的尾部相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表的长度可能不一样，但是两个链表的长度之和是一样的
        ListNode curA = headA, curB = headB;
        // 如果两个链表有重合节点，那么curA和curB一定会在重合节点处相遇
        while (curA!=curB){
            // 如果curA走到了链表的尾部，那么curA就从headB开始走
            curA = curA==null?headB:curA.next;
            // 如果curB走到了链表的尾部，那么curB就从headA开始走
            curB = curB==null?headA:curB.next;
        }

        return curA;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
