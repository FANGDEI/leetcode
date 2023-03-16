package top.dyw.leetcode.simple.list;

/**
 * @author Devil
 * @since 2022-07-17-10:31
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220717103327079.png">
 */
@SuppressWarnings("all")
public class L21合并两个有序链表 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = new L21合并两个有序链表().mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //初始化头结点
        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = new ListNode(list1.val);
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = new ListNode(list2.val);
                p = p.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return listNode.next;
    }
}