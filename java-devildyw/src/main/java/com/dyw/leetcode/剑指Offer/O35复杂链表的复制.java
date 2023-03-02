package com.dyw.leetcode.剑指Offer;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2023-03-01-10:23
 */
@SuppressWarnings("all")
public class O35复杂链表的复制 {

    public static void main(String[] args) {

    }


    HashMap<Node,Node> cacheNode = new HashMap<>();

    /**
     * 题意：实现一个深拷贝
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        if (!cacheNode.containsKey(head)){
            Node NodeNew = new Node(head.val);
            cacheNode.put(head,NodeNew);
            NodeNew.next = copyRandomList(head.next);
            NodeNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

    public Node copyRandomList01(Node head) {
        if (head==null){
            return null;
        }

        for (Node node = head;node!=null;node = node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        for (Node node =head;node!=null;node = node.next.next){
            Node nodeNew = node.next;
            nodeNew.random = (node.random!=null)?nodeNew.random.next:null;
        }

        Node headNew = head.next;
        for (Node node = head;node!=null;node=node.next){
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew!=null)?nodeNew.next.next:null;
        }
        return headNew;
    }



    /**
     * 使用hash表 先根据原节点创建新的节点再将其与原节点存入hashmap中
     * @param head
     * @return
     */
    public Node copyRandomListBest(Node head){
        if (head==null){
            return null;
        }
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        //将新节点与原节点以映射关系存入map中 这样根据原节点就能找到其的复制节点 后续通过这个关系就可以在新节点之间建立指向关系
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }

        //再次遍历根据map在新节点之间建立引用指向关系 借助map就可以很轻松找到指针指向的关系
        cur = head;
        while (cur!=null){
            map.get(cur).next = map.get(cur.next);
            // 之所以random不好确定是因为如果我们要指向的random节点可能还没有创建（因为是随机指向的）所以这里用map一次循环将所有节点都创建了再通过map来指向
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        //返回新链表头结点
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
