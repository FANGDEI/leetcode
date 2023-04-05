package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-13-11:32
 */
@SuppressWarnings("all")
public class BM4合并两个排序的链表 {

    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }

        ListNode head = null, node = null;

        while (list1!=null&&list2!=null){
            int temp;
            if (list1.val<=list2.val){
                temp = list1.val;
                list1 = list1.next;
            }else{
                temp = list2.val;
                list2 = list2.next;
            }

            if (head==null){
                head = new ListNode(temp);
                node = head;
            }else{
                node.next = new ListNode(temp);
                node = node.next;
            }
        }

        if (list1!=null){
            node.next = list1;
        }
        if (list2!=null){
            node.next = list2;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
