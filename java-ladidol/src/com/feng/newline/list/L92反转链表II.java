package com.feng.newline.list;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/21 19:51
 * @description: {}
 */
public class L92反转链表II {


    //参考题解：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/2397023/javapython3cfan-zhuan-lian-biao-chai-fen-ofh0/
    class Solution {


        ListNode reversePre;
        ListNode reverseHead;
        ListNode reverseTail;
        ListNode reverseNext;

        /**
         * 需要明确四个节点：
         * reversePre：反转区间的前一个节点；
         * reverseHead：反转区间的头节点；
         * reverseTail：反转区间的尾节点；
         * reverseNext：反转区间的下一个节点；
         *
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int count = 1;

            ListNode dummy = new ListNode(-1, head);//虚拟头结点，来进行头结点的删除选择操作
            reversePre = dummy;
            while (count < left) {
                //找到翻转区间前一个元素
                reversePre = reversePre.next;
                count++;
            }
//            System.out.println("head = " + reversePre.val);

            reverseHead = reversePre.next;
            ListNode next = null;
            ListNode cur = reverseHead;
            ListNode pre = null;
            while (count <= right) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
            }
            reverseNext = next;
            reverseTail = pre;

//            System.out.println("reverseNext = " + (reverseNext == null ? null : reverseNext.val));
//            System.out.println("reverseTail = " + reverseTail.val);
//            System.out.println("reverseHead = " + reverseHead.val);

            //开始连接回原链表
            reversePre.next = reverseTail;
            reverseHead.next = reverseNext;

            Integer nihao = 1;


            return dummy.next;

        }

    }


}
