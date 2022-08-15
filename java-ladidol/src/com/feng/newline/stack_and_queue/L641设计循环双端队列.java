package com.feng.newline.stack_and_queue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L641设计循环双端队列
 * @author: Ladidol
 * @description: 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * @date: 2022/8/15 12:02
 * @version: 1.0
 */
public class L641设计循环双端队列 {
    class MyCircularDeque {

        //和622设计循环队列类似，只需要start，num，size，int[] 数组就行。
        //只不过这里就是两个指针移动了。
        int[] deque;
        int size;
        int num = 0;
        int start = 0;
//    int end = 0;

        public MyCircularDeque(int k) {
            size = k;
            deque = new int[size];
        }

        public boolean insertFront(int value) {
            if (num == size) return false;
            start = (start + size - 1) % size;//自减取模
            deque[start] = value;
            num++;
            return true;
        }

        public boolean insertLast(int value) {
            if (num == size) return false;
            num++;
            deque[(start + num - 1) % size] = value;//自加取模
            return true;
        }

        public boolean deleteFront() {
            if (num == 0) return false;
            num--;
            start = (start + 1) % size;
            return true;
        }

        public boolean deleteLast() {
            if (num == 0) return false;
            num--;
            return true;
        }

        public int getFront() {
            if (num == 0) return -1;
            return deque[start];
        }

        public int getRear() {
            if (num == 0) return -1;
            return deque[(start + num - 1) % size];
        }

        public boolean isEmpty() {
            return num == 0;
        }

        public boolean isFull() {
            return num == size;
        }
    }
}


