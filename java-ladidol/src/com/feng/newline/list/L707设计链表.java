package com.feng.newline.list;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L707设计链表
 * @author: Ladidol
 * @description:
 * @date: 2022/6/21 21:52
 * @version: 1.0
 */
public class L707设计链表 {
    public static void main(String[] args) {
        MyLinkedList1 linkedList = new MyLinkedList1();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
//        linkedList.get(1);            //返回2
//        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//        linkedList.get(1);            //返回3
        for (int i = 0; i < 3; i++) {
            System.out.println(linkedList.get(i));
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {

    int size;

    //虚拟头节点,当虚拟头结点后置节点的时候就是真实链表为空的时候.
    ListNode dummy;


    public MyLinkedList() {
        this.size = 0;
        this.dummy = new ListNode();
        dummy.next = null;
    }

    public int get(int index) {
        if (index <= -1 || index >= size) {
            return -1;
        }
        ListNode currentNode = dummy;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        //直接遍历到index+1个
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        // 2022/6/21 这里为啥会错误捏, 我现在不太清楚捏
//        ListNode currentNode = new ListNode(val);
//        currentNode.next = dummy.next;
//        dummy.next = currentNode;
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index <= -1 || index > size) {//不是在最后一个就直接返回就行
            return;
        }
        //直接遍历出要插入的地方的前置节点
        ListNode preNode = dummy;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = preNode.next;
        preNode.next = addNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index <= -1 || index >= size) {
            return;
        }
        ListNode preNode = dummy;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        size--;
    }
}

//双向链表
class MyLinkedList1 {
    //双向链表就是,可能在index遍历查询的时候, 就最多走n/2的复杂度!

    int size;

    ListDoubleNode dummyHead;//虚拟头结点,没有前置pre节点
    ListDoubleNode dummyTail;//虚拟尾节点,没有后置next节点
    //当连个虚拟节点相连的时候就是真实链表为空的时候

    public MyLinkedList1() {
        size = 0;
        dummyHead = new ListDoubleNode();
        dummyTail = new ListDoubleNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }


    public int get(int index) {
        if (index <= -1 || index >= size) {
            return -1;
        }
        ListDoubleNode cur;
        if (index < size / 2) {
            cur = dummyHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = dummyTail;
            for (int i = 0; i <= size - index - 1; i++) {
                cur = cur.pre;
            }
        }
        return cur.val;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListDoubleNode preNode = dummyHead;//这里是前置节点哦
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        ListDoubleNode newNode = new ListDoubleNode(val);
        //因为是双向链表咯, 所以这里需要变动四个指针!
        newNode.next = preNode.next;
        preNode.next.pre = newNode;
        newNode.pre = preNode;
        preNode.next = newNode;
        size++;
    }

    public void addAtHead(int val) {
        ListDoubleNode preNode_ = dummyHead;//预备成为前置节点
        ListDoubleNode newNode = new ListDoubleNode(val);
        //同上的注释
        newNode.next = preNode_.next;
        preNode_.next.pre = newNode;
        preNode_.next = newNode;
        newNode.pre = preNode_;
        size++;
    }

    public void addAtTail(int val) {
        ListDoubleNode nextNode_ = dummyTail;//预备成为后置节点
        ListDoubleNode newNode = new ListDoubleNode(val);
        newNode.next = nextNode_;
        newNode.pre = nextNode_.pre;
        nextNode_.pre.next = newNode;
        nextNode_.pre = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        ListDoubleNode preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next.next.pre = preNode;//这里删除的其实就是preNode.next节点
        preNode.next = preNode.next.next;
        size--;
    }

    //对于指定节点的删除
    public void delete(ListDoubleNode node) {
        ListDoubleNode preNode = node.pre;
        node.next.pre = preNode;
        preNode.next = node.next;
        size--;
    }

}
