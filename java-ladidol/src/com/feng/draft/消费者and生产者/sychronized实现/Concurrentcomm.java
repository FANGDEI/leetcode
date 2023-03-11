package com.feng.draft.消费者and生产者.sychronized实现;

import java.util.LinkedList;


/**
 *
 */
public class Concurrentcomm {
    //常量
    private static int MAX_VALUE = 10;
    //可以理解为缓存
    LinkedList<String> linkedList = new LinkedList<>();
    Object object = new Object();
    /*
     * 生产者方法
     */
    public void product() throws Exception {
        synchronized(linkedList) {
            while(MAX_VALUE == linkedList.size()) {
                System.out.println("仓库已满，【生产者】： 暂时不能执行生产任务!");
                linkedList.wait();
            }
            linkedList.push("   李四    ");
            System.out.println("【生产者】：生产了一个产品\t【现仓储量为】:" + linkedList.size());
            linkedList.notifyAll();
        }
    }
    /*
     * 消费者方法
     */
    public void customer() throws Exception {
        /*
         * 根据jdk的void notifyAll()的描述，“解除那些在该对象上调用wait()方法的线程的阻塞状态。该方法只能在同步方法或同步块内部调用。
         * 如果当前线程不是对象所得持有者，
         * 该方法抛出一个java.lang.IllegalMonitorStateException 异常”
         * so我们使用同一把锁
         */
        synchronized (linkedList) {
                        //多线程判断中使用 while 不要使用 if 否则会出现虚假唤醒问题
            while(linkedList.size() == 0) {
                System.out.println("仓库无货，【消费者】： 暂时不能执行消费任务!");
                linkedList.wait();
            }
            linkedList.pop();
            System.out.println("【消费者】：消费了一个产品\t【现仓储量为】:" + linkedList.size());
            linkedList.notifyAll();
        }
    }
}