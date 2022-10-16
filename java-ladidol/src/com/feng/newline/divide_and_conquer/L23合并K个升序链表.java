package com.feng.newline.divide_and_conquer;

import com.feng.newline.list.ListNode;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/13 22:52
 * @description: 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class L23合并K个升序链表 {

    //归并（分治思想）有空用这个来做一下。
    class Solution12 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = new ListNode();

            return null;
        }

    }


    //堆
    class Solution123 {
        /**
         * 参数：[lists]
         * 返回值：com.feng.newline.list.ListNode
         * 作者： ladidol
         * 描述：
         * <p>
         * 直接用堆来实现：很显然可以直接把ListNode可以放进去，不过需要处理一下，不然容易出现环：就如下的报错：
         * 测试用例[[-2,-1,-1,-1],[]]出现：Error - Found cycle in the ListNode
         */
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (ListNode list : lists) {
                while (list != null) {//避免出现环，这里把加进去的节点都断开next；
                    ListNode tmp = list.next;
                    list.next = null;
                    queue.offer(list);
                    list = tmp;
                }
            }

            ListNode ans = queue.peek();
            ListNode cur = queue.poll();

            while (!queue.isEmpty()) {
                cur.next = queue.poll();
                cur = cur.next;
            }
            return ans;
        }
    }


    //继续使用堆呜呜呜呜
    class Solution {//2022年10月16日12:09:25再做

        /**
         * 参数：[lists]
         * 返回值：com.feng.newline.list.ListNode
         * 作者： ladidol
         * 描述：这一次用Integer的queue，不好存最开始的头结点。
         */
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (ListNode list : lists) {
                while (list != null) {
                    queue.offer(list.val);
                    list = list.next;
                }
            }

            ListNode dummy = new ListNode(-1);//先new一个头结点出来，不管是不是虚拟头结点，都能保存ans
            ListNode cur = dummy;//这里表示从头结点开始遍历
            while (!queue.isEmpty()) {
                cur.next = new ListNode(queue.poll());
                cur = cur.next;
            }
            return dummy.next;
        }
    }


}