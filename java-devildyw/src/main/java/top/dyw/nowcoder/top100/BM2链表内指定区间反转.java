package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-12-19:27
 */
@SuppressWarnings("all")
public class BM2链表内指定区间反转 {

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转核心代码
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20221212204225138.png">
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        ListNode cur = head;
        //找到需要交换区间的前一个位置
        for(int i=1;i<m;i++){
            pre = cur;
            cur = cur.next;
        }
        ListNode temp = null;

        //反转内部所有节点 这里用的是交换位置
        for (int i = 0; i < n - m; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummyNode.next;
    }
}
