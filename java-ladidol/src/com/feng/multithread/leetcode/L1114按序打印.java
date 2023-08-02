package com.feng.multithread.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/30 13:50
 * @description: {}
 */
public class L1114按序打印 {


    class Foo {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        private volatile int flag = 1;


        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    condition1.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                flag = 2;//交给第二给来做
                condition2.signal();
            } finally {
                lock.unlock();
            }


        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 2) {
                    condition2.await();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                flag = 3;//交给第二给来做
                condition3.signal();
            } finally {
                lock.unlock();
            }


        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 3) {
                    condition3.await();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();


            } finally {
                lock.unlock();
            }

        }
    }
}
