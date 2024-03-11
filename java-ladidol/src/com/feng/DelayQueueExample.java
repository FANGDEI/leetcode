package com.feng;

import java.util.Iterator;
import java.util.concurrent.*;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayElement> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayElement<String>("test1",1000));
        delayQueue.add(new DelayElement<String>("test2",800));
        delayQueue.add(new DelayElement<String>("test3",2000));
        delayQueue.add(new DelayElement<String>("test4",3000));

        System.out.println("队列大小："+delayQueue.size());
        //立即返回，同时删除元素，如果没有过期元素则返回null
        System.out.println("poll方法获取："+delayQueue.poll());
        //立即返回，不会删除元素，如果没有过期元素也会返回该元素，只有当队列为null时才会返回null
        System.out.println("peek方法获取："+delayQueue.peek());
        //进行阻塞
        System.out.println("take方法获取："+delayQueue.take().getData());

        //立即返回，但不能保证顺序
        Iterator<DelayElement> iterator = delayQueue.iterator();
        while (iterator.hasNext()){
            DelayElement element = iterator.next();
            System.out.println("iterator获取："+element.getData());
        }
    }

    static class DelayElement<E> implements Delayed{
        private final long expireTime;
        private final E e;

        public DelayElement(E e,long delay) {
            this.expireTime = System.currentTimeMillis()+delay;
            this.e = e;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            //判断是否过期
            return unit.convert(expireTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed delayed) {
            //排序规则：按照过期时间排序
            DelayElement that = (DelayElement)delayed;
            if (this.expireTime<that.expireTime){
                return -1;
            }else if (this.expireTime>that.expireTime){
                return 1;
            }else {
                return 0;
            }
        }

        public E getData() {
            return e;
        }
    }
}
