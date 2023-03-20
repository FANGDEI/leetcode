package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/20 19:49
 **/
@SuppressWarnings("all")
public class O52两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;

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
