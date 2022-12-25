package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-25-18:04
 */
@SuppressWarnings("all")
public class BM12单链表的排序 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortInList (ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        //右指针是左指针的两倍速度 所以当右指针到达末尾是 mid 指针刚好指向中间
        while (right!=null&&right.next!=null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }

        //做指针指向左段的最后一个节点，从这里断开
        left.next=null;
        //分成两段排序，合并排好的两段
        return merge(sortInList(head),sortInList(mid));
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1==null){
            return list1;
        }
        if (list2==null){
            return list2;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        if (list1!=null){
            cur.next = list1;
        }else{
            cur.next = list2;
        }
        return dummyNode.next;
    }


}
