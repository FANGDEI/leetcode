package com.feng.draft.高频笔试手撕._1_单例模式;


public class 双检锁单例   {

    private static volatile 双检锁单例 singleTon;

    private 双检锁单例() {
    }

    public static 双检锁单例 getSingleTon(){
        if (singleTon==null){
            synchronized (singleTon){
                //当前线程拿到锁，可能singleTon已经初始化了，需要在判断一下
                if (singleTon==null){
                    singleTon = new 双检锁单例();
                }
            }
        }
        return singleTon;
    }

}
