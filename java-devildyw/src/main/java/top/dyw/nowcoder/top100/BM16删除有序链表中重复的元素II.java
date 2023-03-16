package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-26-12:28
 */
@SuppressWarnings("all")
public class BM16删除有序链表中重复的元素II {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head==null||head.next==null){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode cur = res;
        while (cur.next!=null&&cur.next.next!=null){
            //如果遇到两个节点值相同
            if (cur.next.val==cur.next.next.val){
                int temp = cur.next.val;
                //将所有值相同的节点都跳过
                while (cur.next!=null&&cur.next.val==temp){
                    cur.next=cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }

        return res.next;
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
