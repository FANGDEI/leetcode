package com.feng.面试题;

public class Uninterruptible {
    private static final Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("t1 enter");
            synchronized (o1) {
                try {
                    System.out.println("start lock t1");
                    Thread.sleep(5000);
                    System.out.println("end lock t1");
                } catch (InterruptedException e) {
                    System.out.println("t1 interruptedException");
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("t2 enter");
            synchronized (o1) {
                System.out.println("start lock t2");
                try {

                    for (long i = 0; i < 1111L; i++) {
                    }


                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("e = " + e);
                    System.out.println("t2 interruptedException");
                    throw new RuntimeException(e);
                }
                System.out.println("end lock t2");
            }
        });

        thread1.start();
        thread2.start();

        // 主线程休眠一下，让t1,t2线程百分百已经启动，避免线程交替导致测试结果混淆
        Thread.sleep(4000);
        // 中断t2线程的执行
        thread2.interrupt();
        System.out.println("t2 interrupt...");

    }
}
//复制代码