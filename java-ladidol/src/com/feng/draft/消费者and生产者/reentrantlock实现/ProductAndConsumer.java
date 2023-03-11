package com.feng.draft.消费者and生产者.reentrantlock实现;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过 Lock 实现生产者与消费者
 * 资源类：将公共的资源放在一个单独的类中，可以将其看做一个产品，自身就就有生产和消费的能力（方法）
 */
public class ProductAndConsumer {
    public static void main(String[] args) {
        Resouce resouce = new Resouce();
        //生产者
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                resouce.product();
            }
        }, String.valueOf("生产者")).start();

        //消费者1
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                resouce.consumer();
            }
        }, String.valueOf("消费者One")).start();

        //消费者2
        new Thread(() -> {
            for (int i = 1; i <= 25; i++) {
                resouce.consumerTwo();
            }
        }, String.valueOf("消费者Two")).start();


    }
}

//资源类
class Resouce {
    private int MAX_VALUE = 10;
    private int MIN_VALUE = 0;
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产者
    public void product() {
        try {
            lock.lock();
            //如果生产的数量大于最大值则阻塞
            while (number >= MAX_VALUE) {
                condition.await();
            }
            number++;
            System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费者1
    public void consumer() {
        try {
            lock.lock();
            //如果消费的值=0则阻塞
            while (number <= MIN_VALUE) {
                condition.await();
            }
            number--;
            System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费者2
    public void consumerTwo() {
        try {
            lock.lock();
            //while小于等于零就开始阻塞
            while (number - 1 <= MIN_VALUE) {
                condition.await();
            }
            number-=2;
            System.out.println("【消费者】：消费了两个产品\t【现仓储量为】:" + number);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}