package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/19 21:07
 **/
@SuppressWarnings("all")
public class O22链表中倒数第k个节点 {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = dummyNode.next;

        while(k-->0){
            cur = cur.next;
        }

        while(cur!=null){
            cur = cur.next;
            pre = pre.next;
        }

        return pre.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
