package top.dyw.leetcode.剑指Offer;

import java.util.List;

/**
 * @author Devildyw
 * @date 2023/06/17 15:17
 **/
@SuppressWarnings("all")
public class OII027回文链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
        new OII027回文链表().isPalindrome(listNode);
    }


    /**
     * 反转中间链表后的节点
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }
        //找到中间节点
        ListNode mid = middleNode(head);
        //反转中间节点之后的链表
        ListNode l1 = head, l2 = mid.next;
        l2 = reverseList(l2);
        //判断是否为回文链表
        while (l2!=null){
            if (l1.val!=l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;

    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
