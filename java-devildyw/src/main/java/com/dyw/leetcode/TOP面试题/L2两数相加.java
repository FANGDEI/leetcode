package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-11-30-10:28
 */
@SuppressWarnings("all")
public class L2两数相加 {
    public static void main(String[] args) {

    }

    /**
     * 由题可知 链表中数字都是按照逆序的方式存储的 我们返回的链表也是按逆序存储的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //因为不确定 l1 和 l2 的长度大小关系 所以这里我们新建一个空链表作为结果
        ListNode res = new ListNode();
        ListNode tail = res;
        int add = 0; //用于记录进位值
        while (l1 != null || l2 != null || add != 0) {
            int a1 = l1 == null ? 0 : l1.val;
            int a2 = l2 == null ? 0 : l2.val;
            int result = a1 + a2 + add;
            tail.next = new ListNode(result%10);
            tail = tail.next;

            add = result / 10;

            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        return res.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
