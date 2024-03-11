package com.feng.面试题.深信服;

public class SynchronizedLockExample {
    private static SynchronizedLockExample lock = new SynchronizedLockExample();

//    public static synchronized void outer(){
//        System.out.println(Thread.currentThread().getName()+": First lock acquisition");
//
//
//
//        System.out.println(Thread.currentThread().getName()+": First lock released");
//
//    }
//    public static synchronized  void inner(){
//
//        System.out.println(Thread.currentThread().getName()+": Second lock acquisition");
//
//
//        System.out.println(Thread.currentThread().getName()+"1: Second lock released");
//
//    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock) {

                System.out.println("Thread 1: First lock acquisition");

                synchronized (lock){

                    System.out.println("Thread 1: Second lock acquisition");

                    System.out.println("Thread 1: Second lock released");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }


                System.out.println("Thread 1: First lock released");

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            synchronized (lock){
                System.out.println("Thread 2: Lock acquisition");

                System.out.println("Thread 2: Lock released");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}