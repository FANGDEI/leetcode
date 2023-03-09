package com.jirafa.leetcode.algorithm.剑指;

import com.jirafa.leetcode.utils.Node;

import java.util.HashMap;
import java.util.Map;

public class 剑指35 {
    Map<Node,Node> nodeList=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        if(!nodeList.containsKey(head)){
            Node node = new Node(head.val);
            nodeList.put(head, node);
            node.next=copyRandomList(head.next);
            node.random=copyRandomList(head.random);
        }
        return nodeList.get(head);
    }

}
