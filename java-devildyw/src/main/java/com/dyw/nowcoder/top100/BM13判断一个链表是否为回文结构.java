package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-25-18:37
 */
@SuppressWarnings("all")
public class BM13判断一个链表是否为回文结构 {

    public static void main(String[] args) {

    }

    public boolean isPail (ListNode head) {
        // write code here
        if (head==null||head.next==null){
            return true;
        }

        //找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //中点处反转链表
        slow = reverse(slow);
        fast = head;
        while (slow!=null){
            if (slow.val!= fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;

    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        ListNode cur = slow;
        ListNode temp = null;

        while (cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
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
