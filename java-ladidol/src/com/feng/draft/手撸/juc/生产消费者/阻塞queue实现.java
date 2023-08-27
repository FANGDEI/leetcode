package com.feng.draft.手撸.juc.生产消费者;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 16:10
 * @description: {}
 */
public class 阻塞queue实现 {


    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);


    public void produce() {
        while (FLAG) {
            try {
                blockingQueue.put(atomicInteger.get());
                System.out.println("向队列取中插入一个元素，队列还有空间：" + (10 - blockingQueue.size()));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void consume() {

        while (FLAG) {
            try {
                blockingQueue.take();
                System.out.println("从队列取走一个元素，队列还有" + blockingQueue.size() + "个元素");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            2,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(2)
    );


    public static void main(String[] args) throws InterruptedException {

        阻塞queue实现 queue实现 = new 阻塞queue实现();
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                queue实现.produce();
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                queue实现.consume();
            }
        });


        Thread.sleep(100);
        queue实现.stop();//暂停消费和生产

        threadPoolExecutor.shutdown();

    }


    public void stop() {
        //暂停线程
        FLAG = false;
    }


}
