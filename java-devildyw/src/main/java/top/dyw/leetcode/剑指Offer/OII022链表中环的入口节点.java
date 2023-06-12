package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/12 20:12
 **/
@SuppressWarnings("all")
public class OII022链表中环的入口节点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        listNode.next.next = new ListNode(0);
        ListNode listNode1 = new ListNode(4);
        listNode.next.next.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(new OII022链表中环的入口节点().detectCycle(listNode));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }
        //a点走了a+b，b点走了a+b+c+b，2(a+b)=a+b+c+b，a=c 根据头脑中构建图像来理解
        // 从头开始走，相遇的点就是入口
        ListNode pre = head;
        while (pre != slow) {
            pre = pre.next;
            slow = slow.next;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
