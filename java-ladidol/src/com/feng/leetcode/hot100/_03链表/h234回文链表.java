package com.feng.leetcode.hot100._03链表;

import java.util.ArrayList;
import java.util.List;

public class h234回文链表 {


    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<Integer>();

            // 将链表的值复制到数组中
            ListNode currentNode = head;
            while (currentNode != null) {
                vals.add(currentNode.val);
                currentNode = currentNode.next;
            }

            // 使用双指针判断是否回文
            int left = 0;
            int right = vals.size() - 1;
            while (left < right) {
                if (!vals.get(left).equals(vals.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 通过快慢指针，快指针式慢指针的两倍，快指针每次跳两格，慢指针一格，慢指针每次会反转走过的联表

            ListNode slow = head;
            ListNode fast = head;
            ListNode pre = null;

            // 找到链表中点，同时翻转前半部分
            while(fast!=null&&fast.next!=null){
                fast = fast.next.next;

                ListNode tmp = slow.next;
                slow.next = pre;
                pre = slow;
                slow = tmp;
            }
            // 前后半截对齐
            if (fast != null){
                slow = slow.next;
            }

            // 避免是size=0或者size=1
            if (pre==null) return true;

            if (slow.val!= pre.val){
                 return false;
            }

            // pre和slow同时遍历，检查回文串
            while (slow != null&& pre != null){
                if (slow.val!= pre.val) {
                    return false;
                }
                slow = slow.next;
                pre = pre.next;
            }
            if (slow!=null||pre!=null){
                return false;
            }
            return true;
        }
    }


}
