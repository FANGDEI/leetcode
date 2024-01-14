package com.feng.面试题.数字马力;

import com.feng.newline.list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param val  int整型
     * @return ListNode类
     */
    public ListNode deleteNode(ListNode head, int val) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                return dummy.next;
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;

    }


    public long countPairs(ArrayList<Integer> A, int n, int sum) {
        // write code here

        Map<Integer, Integer> map = new HashMap<>();

        long ans = 0L;
        for (Integer a : A) {
            if (map.containsKey(sum - a)) {
//                map.put(sum - a, 0);
                ans += map.get(sum - a);

            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return ans;
    }

}