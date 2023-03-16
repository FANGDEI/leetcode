package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-25-20:22
 */
@SuppressWarnings("all")
public class BM14链表的奇偶重排 {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList (ListNode head) {
        if (head==null){
            return head;
        }
        //记录偶数位节点
        ListNode even = head.next;
        //记录奇数位节点
        ListNode odd = head;
        ListNode evenHead = even;
        //因为even是最往后的指针所以这里判断它计科
        while (even!=null&&even.next!=null){
            //按照规律将不奇偶的节点拼接
            odd.next = even.next; //偶节点后面一定是奇节点
            odd = odd.next;
            even.next = odd.next; //同理
            even = even.next;
        }

        //拼接起来
        odd.next = evenHead;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
