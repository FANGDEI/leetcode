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

}

class MyLinkedList {
    //记录链表节点个数
    int size;

    //虚拟头结点 方便删除和添加操作
    ListNode dummy;

    public MyLinkedList() {
        //初始化
        size = 0;
        dummy = new ListNode(0);
    }

    //获取第index个节点的值
    public int get(int index) {
        //参数判断
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = dummy;
        //因为我们添加了一个头结点 所以要查找到第index个节点 就要遍历到第index+1个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表的最前头插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表末尾插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }


    /**
     * 在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，
     * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        //参数判断
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        //因为插入节点 所以链表节点数量加一
        size++;

        ListNode pred = dummy;
        //找到目标插入位置的前驱 又因为有虚拟头结点的原因 所以需要找到 index + 1 -1 的位置
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        //找到位置 新建节点准备插入
        ListNode node = new ListNode(val);
        node.next = pred.next;
        pred.next = node;
    }

    public void deleteAtIndex(int index) {
        //参数判断
        if (index<0||index>=size){
            return;
        }

        //因为删除节点 所以链表节点数量减一
        size--;

        ListNode pred = dummy;
        //找到目标前驱
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
