package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-26-12:19
 */
@SuppressWarnings("all")
public class BM15删除有序链表中重复的元素I {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates (ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode pre = head, cur = head.next;
        while (cur!=null){
            if (pre.val==cur.val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;

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
