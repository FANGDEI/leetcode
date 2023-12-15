package top.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-02-20:18
 */
@SuppressWarnings("all")
public class LazySingletonSafeByDoubleLockCheck2 {
    static class Singleton {
        private volatile static Singleton instance = null;//volatile 防止指令重排 初始化对象的步骤 1. 分配内存空间，2. 初始化对象 3. 将对象指向分配的空间

        private Singleton(){}

        public Singleton newInstance(){
            //双检锁
            if (instance==null){
                synchronized (this){
                    if (instance==null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
