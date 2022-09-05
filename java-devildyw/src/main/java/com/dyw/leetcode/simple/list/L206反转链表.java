package com.dyw.leetcode.simple.list;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * @author Devil
 * @since 2022-07-19-10:46
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
@SuppressWarnings("all")
public class L206反转链表 {
    public static void main(String[] args) {

    }

    /**
     * 头插法法 即新建了一个链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode node = null;
        while (head!=null){
            node = new ListNode(head.val);
            node.next = newHead.next;
            newHead.next = node;
            head = head.next;
        }
        return newHead.next;
    }

    /**
     * 双指针 改变链表节点的指向 在原链表基础上修改
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        //记录前驱
        ListNode prev = null;
        //遍历节点
        ListNode cur = head;
        //临时节点
        ListNode temp = null;

        //遍历
        while (cur!=null){
            //通过临时节点 记录cur节点顺序下的下一个节点
            temp = cur.next;
            //然后再将cur.next的指向翻转
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //循环执行直至cur==null
        //再返回prev 此时的prev就是原链表的末尾节点 但是节点指向都翻转了 所以这是翻转后链表的头结点

        return prev;
    }

    /**
     * 递归 与双指针思想类似 只不过是递归实现
     * @param head
     * @return
     */
    public ListNode reverseList02(ListNode head) {
        return reverse(null,head);
    }

    /**
     * 从前往后递归
     * reverse方法只需要前驱节点和当前节点传入 然后改变后面一个节点的指向
     * @param prev
     * @param cur
     * @return
     */
    private ListNode reverse(ListNode prev, ListNode cur) {
        //终止条件
        if (cur == null){
            return prev;
        }
        //临时节点
        ListNode temp = null;
        //保存下一个节点
        temp = cur.next;
        //反转节点指向
        cur.next = prev;
        // 这里可以不用更新prev、cur位置


        return reverse(cur,temp);
    }

    /**
     *
     * 从后往前遍历
     * @param head
     * @return
     */
    public ListNode reverseList03(ListNode head) {
        //边缘条件判断
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return head;
        }

        //递归调用,翻转第二个节点开始往后的链表
        ListNode last = reverseList03(head.next);
        //翻转头结点与第二个节点的指向
        head.next.next = head;
        //此时的 head节点为尾节点，next 需要指向 null
        head.next = null;
        //返回新的头结点
        return last;
    }

}
