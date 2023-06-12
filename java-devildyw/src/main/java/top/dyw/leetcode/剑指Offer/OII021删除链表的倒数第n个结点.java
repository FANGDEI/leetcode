package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/12 19:39
 **/
@SuppressWarnings("all")
public class OII021删除链表的倒数第n个结点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next .next = new ListNode(3);
        listNode.next .next.next = new ListNode(4);
        listNode.next .next.next.next = new ListNode(5);

        System.out.println(new OII021删除链表的倒数第n个结点().removeNthFromEnd(listNode, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        ListNode cur = dummyNode;
        while (n-->0){
            cur = cur.next;
        }
        ListNode pre = dummyNode;
        while (cur.next!=null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
