package com.feng.leetcode.hot100._03链表;

import java.util.ArrayList;
import java.util.List;

public class h234回文链表 {


    class Solution {
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

}
