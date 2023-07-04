package com.feng.draft.消费者and生产者.阻塞队列实现;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.feng.draft.消费者and生产者.阻塞队列实现.BlockProductConsumer.queueSize;

public class BlockProductConsumer {
    static int queueSize = 100000;
    public static void main(String[] args) {
        MyResouce resouce = new MyResouce(new ArrayBlockingQueue(queueSize));
        //生产者线程
        new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                resouce.product();
            }
        }, "生产者").start();

        //消费者线程
        new Thread(() -> {
            for (int i = 1; i <= 1; i++) {
                try {
                    resouce.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();

        try {
            //执行时间控制
            TimeUnit.MILLISECONDS.sleep(10000);
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
                System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - blockingQueue.size()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者
    public void consumer() throws InterruptedException {
        while (FLAG) {
            blockingQueue.take();
            System.out.println("从队列取走一个元素，队列剩余" + blockingQueue.size() + "个元素");
        }
    }

    public void stop() {
        FLAG = false;
        System.out.println("===============stop！！！！=========");
    }
}