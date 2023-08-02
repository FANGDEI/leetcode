package com.feng.multithread.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/30 15:53
 * @description: {}
 */
public class L1117H2O生成 {



    class H2O {

        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        volatile int flag = 1;


        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        }
    }
}
