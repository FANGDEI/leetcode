package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

import java.util.Stack;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/15 17:41
 * @description: {}
 */
public class 剑指OfferII025链表中的两数相加 {


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }


            int carry = 0;
//            ListNode nextNode = null;
            ListNode ans = null;//ans这里就是做的nextNode的角色
            while (!stack1.empty() || !stack2.empty() || carry != 0) {
                Integer num1 = stack1.isEmpty() ? 0 : stack1.pop();
                Integer num2 = stack2.isEmpty() ? 0 : stack2.pop();
                int curVal = carry + num1 + num2;
                carry = curVal / 10;//进位
                curVal = curVal % 10;//一位数
                ListNode curNode = new ListNode(curVal);
                curNode.next = ans;
                ans = curNode;

            }
            return ans;
        }
    }

}
