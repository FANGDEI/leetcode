package com.dyw.leetcode.周赛.第321周;

import com.dyw.leetcode.medium.list.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-11-27-11:31
 */
@SuppressWarnings("all")
public class L6247从链表中移除节点 {
    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 将链表节点的值存在单调栈中 再从单调栈中反向取出数据构建新的链表
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node= head; node!=null;node=node.next){
            while (!stack.isEmpty()&&node.val>stack.peek()){
                stack.pop();
            }
            stack.push(node.val);
        }

        ListNode newHead = null, node = null, tail = null;
        while (!stack.isEmpty()){
            if (newHead==null){
                node = new ListNode(stack.pollLast());
                newHead = node;
            }else{
                tail = new ListNode(stack.pollLast());
                node.next = tail;
                node = node.next;
                tail = tail.next;
            }


        }

        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
