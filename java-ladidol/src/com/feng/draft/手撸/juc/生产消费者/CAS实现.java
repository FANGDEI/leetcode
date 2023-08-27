package com.feng.draft.手撸.juc.生产消费者;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 15:55
 * @description: {}
 */
public class CAS实现 {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2,
            2,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(2)
    );


    private static final int MAX_CAPACITY = 10;
    private AtomicInteger count = new AtomicInteger(0);

    public void produce() {

        for (int i = 0; i < 50; i++) {
            while (count.get() == MAX_CAPACITY) {
                //如果生产到10个了，就先不生产了
            }

            System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + count.incrementAndGet());
            try {
                Thread.sleep(10);//模拟生产
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    public void consume(){
        for (int i = 0; i < 50; i++) {
            while (count.get() == 0) {
                //如果消费完了，就等会了。
            }

            System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + count.decrementAndGet());
            try {
                Thread.sleep(15);//模拟消费
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static void main(String[] args) {
        CAS实现 cas实现 = new CAS实现();

        threadPoolExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        cas实现.consume();
                    }
                }
        );
        threadPoolExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        cas实现.produce();
                    }
                }
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        threadPoolExecutor.shutdown();

    }

}
