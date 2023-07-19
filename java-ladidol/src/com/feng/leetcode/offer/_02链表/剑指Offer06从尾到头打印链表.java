package com.feng.leetcode.offer._02链表;

import java.util.LinkedList;

public class 剑指Offer06从尾到头打印链表 {


    //递归（新颖的方法）
    class Solution {

        /**
         * 递归，从底层回来的时候，在进行数据添加，这时候数据就是逆序了。
         *
         * @param head
         * @return
         */
        LinkedList<Integer> res = new LinkedList<>();

        public int[] reversePrint(ListNode head) {
            if (head == null) return new int[]{};
            dfs(head);
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }


        private void dfs(ListNode node) {
            if (node == null) return;
            dfs(node.next);//先dfs
            res.add(node.val);
        }
    }


}
