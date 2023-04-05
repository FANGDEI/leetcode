package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-15-12:24
 */
@SuppressWarnings("all")
public class BM10两个链表的第一个公共结点 {

    public static void main(String[] args) {

    }

    /**
     * 先找到两个链表长度的差值 再根据差值将两个链表终点位置对齐 从相同的起始位置出发直到找到相同的值为止
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0;
        int length2 = 0;

        ListNode temp = pHead1;
        while (temp!=null){
            temp = temp.next;
            length1++;
        }

        temp = pHead2;
        while (temp!=null){
            temp = temp.next;
            length2++;
        }

        ListNode index1 = pHead1;
        ListNode index2 = pHead1;

        int dis = Math.abs(length1 - length2);

        if (length1>length2){
            while (dis-->0){
                index1 = index1.next;
            }
        }else{
            while (dis-->0){
                index2 = index2.next;
            }
        }

        while (index1!=null&&index2!=null){
            if (index1==index2){
                return index1;
            }
            index1=index1.next;
            index2 = index2.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
