package com.feng.面试题;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();



    public void doSomething() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + "，开始获取锁");




            System.out.println(name + "，得到锁，开工干活");

//            LockSupport.park();
            TimeUnit.SECONDS.sleep(1000);
            Thread.sleep(10000);





        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lock.unlock();
                System.out.println(name + "，成功释放锁");
            } catch (Exception e) {
                System.out.println(name + "，释放锁异常："+ e);
            }
        }


//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            System.out.println(name + "，第二次开始获取锁");
//
//            lock.lockInterruptibly();
//            System.out.println(name + "，第二次得到锁，开工干活");
//            for (int i = 1; i <= 5; i++) {
//            Thread.sleep(500);
//                System.out.println(name + ": " + i);
//            }
//        } catch (InterruptedException e) {
//            System.out.println(name + "，被中断了，抛出异常：" + e);
//        } finally {
//            try {
//                lock.unlock();
//                System.out.println(name + "，成功释放锁");
//            } catch (Exception e) {
//                System.out.println(name + "，释放锁异常："+ e);
//            }
//        }




    }

    public static void main(String[] args) throws InterruptedException {
        LockTest lockTest = new LockTest();
        Thread t1 = new Thread(() -> lockTest.doSomething(), "线程一");
        Thread t2 = new Thread(() -> lockTest.doSomething(), "线程二");
        // 启动线程t1
        t1.start();
        //让线程一先启动
        Thread.sleep(10);
        // 启动线程t2
        t2.start();
        Thread.sleep(100);
        t2.join();

        // 线程t1没有得到锁，中断t1的等待
        System.out.println("主线程执行：t2.interrupt()");
        t1.interrupt();
    }
}
//执行结果：
//线程一，开始获取锁
//线程一，得到锁，开工干活
//线程二，开始获取锁
//主线程执行：t2.interrupt()
//线程二，被中断了，抛出异常：java.lang.InterruptedException
//线程二，释放锁异常：java.lang.IllegalMonitorStateException
//线程一: 1
//线程一: 2
//线程一: 3
//线程一: 4
//线程一: 5
//线程一，成功释放锁
