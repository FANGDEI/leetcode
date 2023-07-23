package com.feng.leetcode.offer._06查找算法;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOrderDemo {
    private Lock lock = new ReentrantLock();
    private Condition t1Condition = lock.newCondition();
    private Condition t2Condition = lock.newCondition();
    private Condition t3Condition = lock.newCondition();
    private volatile int flag = 1;

    public void t1() {
        lock.lock();
        try {
            while (flag != 1) {
                t1Condition.await();
            }
            System.out.println("Thread T1 is running.");
            flag = 2;
            t2Condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadOrderDemo demo = new ThreadOrderDemo();
        Thread t1 = new Thread(() -> {
            while (true) {
                demo.t1();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                demo.t2();
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                demo.t3();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }




    public void t2() {
        lock.lock();
        try {
            while (flag != 2) {
                t2Condition.await();
            }
            System.out.println("Thread T2 is running.");
            flag = 3;
            t3Condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void t3() {
        lock.lock();
        try {
            while (flag != 3) {
                t3Condition.await();
            }
            System.out.println("Thread T3 is running.");
            flag = 1;
            t1Condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}