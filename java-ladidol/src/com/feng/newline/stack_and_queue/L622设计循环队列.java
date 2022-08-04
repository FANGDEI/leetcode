package com.feng.newline.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L622设计循环队列
 * @author: Ladidol
 * @description: 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * @date: 2022/8/2 12:23 每日一题
 * @version: 1.0
 */
public class L622设计循环队列 {


    class MyCircularQueue {
        int[] circularQueue;
        int size = 0;//大小
        int start = 0;//出口指针，入口指针就是(start + num - 1)%size
        int num = 0;//当前个数

        public MyCircularQueue(int k) {
            circularQueue = new int[k];
            size = k;
        }

        public boolean enQueue(int value) {
            if (num == size) return false;
            num++;
            circularQueue[(start + num - 1)%size] = value;
            return true;
        }

        public boolean deQueue() {
            if (num == 0) return false;
            start = (start + 1) % size;
            num--;
            return true;
        }

        public int Front() {
            if (num == 0) return -1;
            return circularQueue[start];
        }

        public int Rear() {
            if (num == 0) return -1;
            return circularQueue[(start + num - 1)%size];
        }

        public boolean isEmpty() {
            return num == 0;
        }

        public boolean isFull() {
            return num == size;
        }
    }
}
