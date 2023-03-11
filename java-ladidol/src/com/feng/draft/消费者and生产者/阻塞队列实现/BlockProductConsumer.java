package com.feng.draft.消费者and生产者.阻塞队列实现;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockProductConsumer {
    public static void main(String[] args) {
        MyResouce resouce = new MyResouce(new ArrayBlockingQueue(5));
        //生产者线程
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                resouce.product();
            }
        }, "生产者").start();

        //消费者线程
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    resouce.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();

        try {
            //执行时间控制
            TimeUnit.MILLISECONDS.sleep(1000);
            resouce.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 公共资源类
 */
class MyResouce {
    //标记 while 无限循环
    private volatile boolean FLAG = true;
    //队列中存入的数值
    private AtomicInteger atomicInteger = new AtomicInteger();
    //组合一个阻塞队列，通过构造器传入
    private BlockingQueue blockingQueue;

    public MyResouce(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //生产者
    public void product() {
        try {
            while (FLAG) {
                blockingQueue.put(String.valueOf(atomicInteger.incrementAndGet()));
                System.out.println("生产者生产第" + blockingQueue.size() + "个产品");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者
    public void consumer() throws InterruptedException {
        while (FLAG) {
            blockingQueue.take();
            System.out.println("消费者消费第" + (blockingQueue.size() + 1) + "个产品");
        }
    }

    public void stop() {
        FLAG = false;
        System.out.println("===============stop！！！！=========");
    }
}