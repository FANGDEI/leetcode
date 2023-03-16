package top.dyw.leetcode.hard.list;



/**
 * @author Devil
 * @since 2022-08-08-10:26
 *
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 */
@SuppressWarnings("all")
public class L25K个一组翻转链表 {
    public static void main(String[] args) {

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);

        ListNode pre = hair;
        while (head!=null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail==null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }


    /**
     * 翻转head 到 tail之间的节点
     * @param head
     * @param tail
     * @return
     */
    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next; //获取尾节点的next节点
        ListNode p = head; //记录头部结点 最后要返回头结点和尾结点 所以头结点不能去变化
        //翻转 将范围之间的节点全部倒插一遍
        while (prev!=tail){
            //使用变量记录p节点的next
            ListNode nex = p.next;
            p.next = prev; //将prev的赋值给p的next
            prev = p; //在将tail.next赋值为p
            p = nex; //p向下走一步
            //即将p所指的结点不断插入到tail.next上
        }
        return new ListNode[]{tail,head};
    }
}
