package com.feng.leetcode.offer._02链表;

import java.util.HashMap;
import java.util.Map;

public class 剑指Offer35复杂链表的复制 {




    //模拟+哈希
    class Solution {
        /**
         * 难点无非是，random这个指向难点，我们找不到对应的下一个节点也，不能通过val来判断
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            Node dummy = new Node(-10001);
            Node cur = dummy, tmp  = head;
            Map<Node,Node> map = new HashMap<>();
            //先把主干给复制一下
            while(head!=null){
                Node newNode = new Node(head.val);
                cur.next = newNode;
                cur = cur.next;
                map.put(head,newNode);//新旧节点对应
                head = head.next;
            }
            //继续从头再来
            cur = dummy.next;
            head = tmp;
            while(head!=null){
                cur.random = map.get(head.random);
                cur = cur.next;
                head = head.next;
            }
            return dummy.next;
        }
    }

}
