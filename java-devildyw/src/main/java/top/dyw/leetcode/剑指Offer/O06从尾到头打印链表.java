package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author Devil
 * @since 2023-02-28-11:38
 */
@SuppressWarnings("all")
public class O06从尾到头打印链表 {
    public static void main(String[] args) {

    }


    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
