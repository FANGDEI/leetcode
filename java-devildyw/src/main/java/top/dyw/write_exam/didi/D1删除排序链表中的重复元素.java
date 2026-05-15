package top.dyw.write_exam.didi;

public class D1删除排序链表中的重复元素 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode head) {
            this.val = val;
            this.next = head;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(2);
//        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(3);
//        listNode.next.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next.next = new ListNode(5);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);


        ListNode delete = delete(listNode);

        while (delete!=null) {
            System.out.println(delete.val);
            delete = delete.next;
        }
    }

    public static ListNode delete(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
