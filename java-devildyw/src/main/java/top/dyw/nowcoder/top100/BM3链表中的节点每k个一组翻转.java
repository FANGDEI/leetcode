package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-13-11:14
 */
public class BM3链表中的节点每k个一组翻转 {

    public static void main(String[] args) {

    }


    /**
     * 思路：
     * 1. 首先计算出链表的长度 然后计算出要执行多少次反转n（length/k）
     * 2. 执行n次反转 反转使用的是改变位置的方法
     * 3. 每次反转完成都会更新pre指针和cur指针
     * 4. 最后返回结果
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int length = 0;
        ListNode cur = head;

        while (cur!=null){
            length++;
            cur = cur.next;
        }
        int count = length/k;
        ListNode pre = dummyNode;
        cur = head;

        for (int i = 0; i < count; i++) {
            if (i!=0){
                pre = cur;
                cur = cur.next;
            }
            for (int j = 0; j < k-1; j++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }

        return dummyNode.next;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
