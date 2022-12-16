package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-14-11:32
 */
@SuppressWarnings("all")
public class BM8链表中倒数最后k个结点 {
    public static void main(String[] args) {

    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode cur = pHead;
        int length = 0;
        while (cur!=null){
            length++;
            cur = cur.next;
        }

        if (length<k){
            return null;
        }

        ListNode pre = pHead;
        cur = pHead;
        while (k-->0){
            cur = cur.next;
        }

        while (cur!=null){
            pre = pre.next;
            cur = cur.next;
        }

        return pre;
    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
