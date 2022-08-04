package com.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-04-12:10
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
@SuppressWarnings("all")
public class L82删除排序链表中的重复元素II {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }

        //防止原来的head重复而发生改变 这里使用一个头结点来优化
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy; //初始化为头结点
        //cur是作为一次遍历的节点  需要判断后续是否有重复的节点 所以这里判断cur.next 和它相邻的cur.next.next
        while (cur.next!=null&&cur.next.next!=null){
            //如果恰好这两个相邻的节点的值相等 继续寻找后续是否还有重复的节点 因为是排序过的 按这个顺序找到没有重复的为止就行了
            if (cur.next.val==cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    //不断更新cur.next;
                    cur.next = cur.next.next;
                }
            }else {
                //如果不重复 移动指针
                cur = cur.next;
            }
        }
        //返回结果
        return dummy.next;
    }
}
