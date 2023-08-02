package com.feng.multithread.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/30 14:17
 * @description: {}
 */
public class L1116打印零与奇偶数 {

    static class ZeroEvenOdd {

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        volatile int flag = 1;


        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {


            for (int i = 1; i <= n; i++) {
                lock.lock();
                try {
                    while (flag != 1) {
                        condition1.await();
                    }
                    printNumber.accept(0);

//                    System.out.println(0);

                    if (i % 2 == 0) {
                        flag = 2;
                        condition2.signal();
                    } else {
                        flag = 3;
                        condition3.signal();
                    }
                } finally {
                    lock.unlock();
                }
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {

            for (int i = 2; i <= n; ) {
                lock.lock();
                try {
                    while (flag != 2) {
                        condition2.await();
                    }
                    printNumber.accept(i);

//                    System.out.println(i);

                    flag = 1;
                    i += 2;
                    condition1.signal();
                } finally {
                    lock.unlock();
                }
            }

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; ) {
                lock.lock();
                try {
                    while (flag != 3) {
                        condition3.await();
                    }
                    printNumber.accept(i);

//                    System.out.println(i);

                    flag = 1;
                    i += 2;
                    condition1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(new IntConsumer() {
                    @Override
                    public void accept(int value) {

                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread one = new Thread(() -> {
            try {
                zeroEvenOdd.odd(new IntConsumer() {
                    @Override
                    public void accept(int value) {

                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even(new IntConsumer() {
                    @Override
                    public void accept(int value) {

                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        zero.start();
        one.start();
        even.start();


    }


}
