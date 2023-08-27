package com.feng.draft.手撸.juc.生产消费者;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/27 15:23
 * @description: {}
 */
public class Lock实现 {


    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    private volatile int count = 0;

    public void consumer() {


        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                while (count <= 0) {
                    condition.await();
                }
                count--;
                System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + count);
                condition.signalAll();
            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            } finally {

                lock.unlock();
            }
        }
    }

    public void product() {

        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                while (count >= 10) {
                    condition.await();
                }
                count++;
                System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + count);
                condition.signalAll();
            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            } finally {

                lock.unlock();
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


        Lock实现 resouce = new Lock实现();

        threadPoolExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        resouce.product();
                    }
                }
        );
        threadPoolExecutor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        resouce.consumer();
                    }
                }
        );

        Thread.sleep(100);



        threadPoolExecutor.shutdown();

    }


}
