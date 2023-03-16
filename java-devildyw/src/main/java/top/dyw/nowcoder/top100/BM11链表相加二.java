package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-15-12:34
 */
@SuppressWarnings("all")
public class BM11链表相加二 {

    public static void main(String[] args) {

    }

    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        //首先反转两个链表 因为相加是从尾开始的 而单项链表没有这样的从尾部开始的访问方式
        head1 = ReverseList(head1);
        head2 = ReverseList(head2);

        int add = 0;
        ListNode index1 = head1;
        ListNode index2 = head2;

        ListNode head = new ListNode(-1), node = null;
        while (index1!=null||index2!=null||add!=0){
            int a1 = index1!=null?index1.val:0;
            int a2 = index2!=null?index2.val:0;

            int result = add + a1+a2;

            //再用尾插法构建结果 就可以得到相加后的链表了
            node = new ListNode(result%10);
            node.next = head.next;
            head.next = node;

            add = result/10;

            if (index1!=null){
                index1 = index1.next;
            }
            if (index2!=null){
                index2 = index2.next;
            }
        }

        return head.next;


    }

    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
