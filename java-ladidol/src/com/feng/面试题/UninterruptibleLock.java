package com.feng.面试题;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UninterruptibleLock {
    private static final Object o1 = new Object();

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("t1 enter");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println("start lock t1");
                Thread.sleep(5000);
                System.out.println("end lock t1");
            } catch (InterruptedException e) {
                System.out.println("t1 interruptedException");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("t2 enter");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("e = " + e);
                throw new RuntimeException(e);
            }
            try {
                System.out.println("start lock t2");
//                    Thread.sleep(1000);
                System.out.println("end lock t2");
            } finally {
                lock.unlock();
            }

        });

        thread1.start();
        thread2.start();

        // 主线程休眠一下，让t1,t2线程百分百已经启动，避免线程交替导致测试结果混淆
        Thread.sleep(1000);
        // 中断t2线程的执行
        thread2.interrupt();
        System.out.println("t2 interrupt...");

    }
}
//复制代码