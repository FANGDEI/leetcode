package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/03/19 20:58
 **/
@SuppressWarnings("all")
public class O18删除链表的节点 {

    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head!=null){
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode, cur = dummyNode.next;
        while(cur!=null){
            if (cur.val==val){
                //相同时，将pre的next指向cur的next
                pre.next = cur.next;
            }else{//当不相同时，pre可以到next的位置，防止cur的next也是需要删除的节点
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
