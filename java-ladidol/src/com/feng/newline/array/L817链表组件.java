package com.feng.newline.array;

import com.feng.newline.list.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ladidol
 * @date: 2022/10/12 10:40
 * @description: 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * 示例 1：
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * 提示：
 * <p>
 * 链表中节点数为n
 * 1 <= n <= 104
 * 0 <= Node.val < n
 * Node.val 中所有值 不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值 不同
 */
public class L817链表组件 {


    //哈希
    class Solution {

        /*
         * 参数：[head, nums]
         * 返回值：int
         * 作者： ladidol
         * 描述：
         */
        public int numComponents(ListNode head, int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int ans = 0;
            ListNode cur = head;
            while (cur != null) {
                if (set.contains(cur.val)) {
                    ans++;
                    cur = cur.next;
                    while (cur != null && set.contains(cur.val)) {
                        cur = cur.next;
                    }
                }
                if (cur == null) break;
                //这里就是不在set中的list
                cur = cur.next;
            }
            return ans;
        }
    }
}