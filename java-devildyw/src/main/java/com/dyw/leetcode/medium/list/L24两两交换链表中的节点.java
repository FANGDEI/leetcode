package com.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-07-12:48
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
@SuppressWarnings("all")
public class L24两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode li = new L24两两交换链表中的节点().swapPairs(listNode);
        while (li!=null){
            System.out.println(li.val);
            li = li.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead;
        while (p.next != null && p.next.next != null) {
            ListNode pre = p.next, cur = p.next.next;
            pre.next = cur.next;
            cur.next = pre;
            p.next = cur;
            p = p.next.next;
        }

        return newHead.next;
    }


    /**
     * 迭代版本 一定要画图理解
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041117387.png">
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041118074.png">
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041117640.png">
     *
     * @param head
     * @return
     */
    public ListNode swapPairs01(ListNode head) {
        //虚拟头结点
        ListNode dummyNode = new ListNode(0, head);
        //前驱节点
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; //缓存 next
            prev.next = head.next; //将 prev 的next 改为 head的next 对应步骤一
            head.next.next = head; //将head.next(prev.next) 的next 指向 head 对应步骤二
            head.next = temp; //将head 的 next 接上缓存的temp //对应步骤三
            prev = head; //步进一位
            head = head.next; //步进一位
        }
        return dummyNode.next;
    }

    /**
     * 递归版本
     *
     * 从后往前 交换两两之间的指向关系
     * @param head
     * @return
     */
    public ListNode swapPairs02(ListNode head) {
        //终止条件判断
        if (head == null || head.next == null){
            return head;
        }

        //获取当前节点的下一个节点
        ListNode next = head.next;
        //进行递归 因为从后往前 所以这里获取的是后面已经交换好的链表的第一个节点
        ListNode newNode = swapPairs02(next.next);
        //这里进行交换
        next.next = head; //反转节点指向 对应步骤二
        head.next = newNode; //将前一个节点的next指向后一个节点的next节点 对应步骤三

        //返回交换后的节点
        return next;
    }
}
