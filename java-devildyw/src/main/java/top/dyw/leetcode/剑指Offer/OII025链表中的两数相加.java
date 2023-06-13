package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/06/13 20:02
 **/
@SuppressWarnings("all")
public class OII025链表中的两数相加 {
    public static void main(String[] args) {

    }

    /**
     * 反转链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        int carry = 0;
        ListNode res = null;
        while (l1!=null||l2!=null||carry!=0){
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            ListNode temp = new ListNode(sum%10);
            //尾插法
            temp.next = res;
            res = temp;
        }
        return res;
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


    /**
     * 栈的做法（进阶）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }


    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
