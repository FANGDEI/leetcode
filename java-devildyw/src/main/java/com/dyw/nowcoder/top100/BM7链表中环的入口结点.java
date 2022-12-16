package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-14-10:31
 */
@SuppressWarnings("all")
public class BM7链表中环的入口结点 {

    public static void main(String[] args) {

    }

    /**
     * <img src="https://code-thinking-1253855093.file.myqcloud.com/pics/20220925103433.png">
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow =pHead;
        ListNode fast = pHead;

        //fast 指针走了 x+y+n*(y+z)的距离 与 slow 走了 x+y 的距离相遇了
        //而 x+y+n*(y+z) = (x+y)*2
        // n(y+z) = x+y;
        // n==1 x=z 所以从相遇的那个节点算起 一个从头结点开始走的指针和一个从相遇节点开始走的指针每次移动同样的距离相遇的地方就是环入口点
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                ListNode node1 = fast;
                ListNode node2 = pHead;

                while (node1!=node2){
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node2;
            }
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
