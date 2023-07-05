package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/04 12:13
 **/
@SuppressWarnings("all")
public class OII029排序的循环链表 {

    public static void main(String[] args) {

    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        //如果是空列表
        if (head==null){
            node.next = node;
            return node;
        }

        if (head.next==head){
            head.next = node;
            node.next = head;
            return head;
        }

        Node cur = head, next = head.next;
        //如果元素都相同则直接进入插入操作 因为插入到哪里都是ok的不需要选择插入位置 另一个含义也就是循环一圈
        while (next!=head){
            //适用于 1 3 4 insertVal 为 2 的情况
            if (insertVal>=cur.val&&insertVal<=next.val){
                break;
            }
            //适用于 3 4 2 insertVal 为 1 或者 5 的情况
            if (cur.val>next.val){
                if (insertVal>cur.val||insertVal<next.val){
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }

        //插入操作
        cur.next = node;
        node.next = next;

        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
