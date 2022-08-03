package com.dyw.leetcode.medium.list;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-08-03-19:10
 * <p>
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * <p>
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <p>
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 */
@SuppressWarnings("all")
public class L142环形链表II {
    public static void main(String[] args) {

    }

    /**
     * 使用 hash表存储链表节点 每次遍历都去与hash表比较是否之前遍历过
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur!=null){
            if (set.contains(cur)){
                return cur;
            }else{
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}
