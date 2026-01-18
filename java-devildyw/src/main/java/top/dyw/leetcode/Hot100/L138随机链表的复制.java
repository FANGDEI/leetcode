package top.dyw.leetcode.Hot100;

public class L138随机链表的复制 {
    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(-1);
        Node cur = dummyNode;

        HashMap<Node, Node> map = new HashMap<>();

        while(head != null) {
            Node newNode = new Node(head.val);
            newNode.random = head.random;
            map.put(head, newNode);
            head = head.next;
            cur.next = newNode;
            cur = cur.next;
        }

        cur = dummyNode.next;
        while(cur!=null){
            if (cur.random != null) {
                cur.random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }
}
