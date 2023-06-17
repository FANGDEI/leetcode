package top.dyw.leetcode.剑指Offer;



/**
 * @author Devildyw
 * @date 2023/06/17 14:50
 **/
@SuppressWarnings("all")
public class OII026重排链表 {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null){
            return;
        }
        //找到中间节点
        ListNode mid = middleNode(head);
        //反转中间节点之后的链表
        ListNode l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        //合并两个链表
        mergeList(l1, l2);

    }

    //合并链表 只用按照l1在前l2在后的顺序合并即可
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode temp1, temp2;
        while (l1!=null&&l2!=null){
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }

    //反转二号链表
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

    //查找中间节点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
