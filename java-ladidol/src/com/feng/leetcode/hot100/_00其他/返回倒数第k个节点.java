/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._00其他;

import com.feng.leetcode.hot100._03链表.ListNode;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/7 10:39
 */
public class 返回倒数第k个节点 {

  class Solution {

    public int kthToLast(ListNode head, int k) {
      // 前后指针
      ListNode fast = head;
      ListNode slow = head;
      while (k > 0 && fast != null) {
        fast = fast.next;
        k--;
      }
      if (fast == null && slow != null) {
        return slow.val;
      }
      if (fast == null) {
        return 0;
      }
      while (fast != null) {
        fast = fast.next;
        slow = slow.next;
      }
      return slow.val;
    }
  }


}
