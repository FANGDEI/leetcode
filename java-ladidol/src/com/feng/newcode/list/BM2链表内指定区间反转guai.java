package com.feng.newcode.list;

import com.feng.newline.list.ListNode;

import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/3 11:33
 * @description: {}
 */
public class BM2链表内指定区间反转guai {


    public class Solution {
        /**
         * curr：指向待反转区域的第一个节点 left；
         * Cur_next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 Cur_next 会变化；
         * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
         * <p>
         * <p>
         * 看题解很明朗https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=23286&ru=%2Fexam%2Foj&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D295
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            //先得到pre节点
            int cnt = 1;
            ListNode dumpHead = new ListNode(-1);
            dumpHead.next = head;
            ListNode pre = dumpHead;//引入虚拟节点的作用
            while (cnt < m) {
                pre = pre.next;
                cnt++;
            }
            //看是使用这三个特殊节点来局部翻转链表
            ListNode cur = pre.next;
            ListNode Cur_next;
            for (int i = m; i < n; i++) {
                Cur_next = cur.next;
                cur.next = Cur_next.next;
                Cur_next.next = pre.next;
                pre.next = Cur_next;
            }
            return dumpHead.next;
        }
    }
}
