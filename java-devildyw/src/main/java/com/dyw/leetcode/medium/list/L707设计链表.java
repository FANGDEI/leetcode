package com.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-07-13:13
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 */
@SuppressWarnings("all")
public class L707设计链表 {
    public void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.get(1);
    }

    class MyLinkedList {
        ListNode head;
        public MyLinkedList() {
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index<0||index>= head.val){
                return -1;
            }
            ListNode curr = head;
            // index steps needed
            // to move from sentinel node to wanted index
            for(int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(head.val,val);
        }

        public void addAtIndex(int index, int val) {
            if (index> head.val){
                return;
            }

            if (index<0){
                index = 0;
            }

            head.val++;
            ListNode prod = head;

            for (int i = 0; i < index; i++) {
                prod = prod.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = prod.next;
            prod.next = toAdd;
        }

        public void deleteAtIndex(int index) {
            // if the index is invalid, do nothing
            if (index < 0 || index >= head.val) {
                return;
            }

            head.val--;
            // find predecessor of the node to be deleted
            ListNode pred = head;
            for(int i = 0; i < index; ++i) {
                pred = pred.next;
            }

            // delete pred.next
            pred.next = pred.next.next;

        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
