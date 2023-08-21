package com.feng.面试题;

public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 执行一些操作






                // 检查中断状态
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted, exiting...");
                    break;
                }







            }




        });

        thread.start();

        // 主线程休眠一段时间
        Thread.sleep(1000);

        // 中断目标线程
        thread.interrupt();
        thread.join();


    }
}