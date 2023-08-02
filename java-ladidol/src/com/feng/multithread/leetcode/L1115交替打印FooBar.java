package com.feng.multithread.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/29 12:24
 * @description: {}
 */
public class L1115交替打印FooBar {


    //用ReentrantLock和Condition来做
    static class FooBar1 {

        Lock lock = new ReentrantLock();

        Condition conditionFoo = lock.newCondition();
        Condition conditionBar = lock.newCondition();

        volatile boolean flag = true;


        private int n;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();//加锁保证原子性
                try {
                    while (!flag) {
                        conditionFoo.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = !flag;
                    conditionBar.signal();
                } finally {
                    lock.unlock();
                }

            }
        }


        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (flag) {
                        conditionBar.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = !flag;
                    conditionFoo.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class FooBar {
        private int n;
        private volatile boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (flag){
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    i++;
                    flag = false;
                }else {
                    Thread.yield();//礼让，重新争抢
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; ) {
                if (!flag){
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    i++;
                    flag = true;
                }else {
                    Thread.yield();
                }

            }
        }
    }




    /**
     *
     */
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread bar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        foo.start();
        bar.start();


    }




}
