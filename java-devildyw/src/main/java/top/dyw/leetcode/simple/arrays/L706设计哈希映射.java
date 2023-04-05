package top.dyw.leetcode.simple.arrays;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Devil
 * @date 2022-05-25-12:07
 */
@SuppressWarnings("all")
public class L706设计哈希映射 {


}

/**
 * 同样采用连地址法 使用linkedList数组模拟hash表
 */
@SuppressWarnings("all")
class MyHashMap {
    //哈希表大小
    private static final int BASE = 769;
    //链地址法 使用链表来存储每个哈希表节点的hash值相同的值
    private LinkedList[] set;

    //构造函数 初始化hash表
    public MyHashMap() {
        //初始化化hash表 这里初始化hash表大小
        set = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            //初始化hash表每个索引上的链表
            set[i] = new LinkedList<Pair>();
        }
    }

    public static int hash(int key) {
        return key % BASE;
    }

    /**
     * 加入元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //通过hash映射得到hash值
        int h = hash(key);
        //通过这个hash值在对应位置的链表的迭代器上 迭代元素
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()) {
            //取出元素
            Pair next = (Pair) iterator.next();
            //如果有hash值连同key值相同的元素 代表他们的key相同 需要将value更新为新的值
            if (next.getKey() == key) {
                next.setValue(value);
                return;
            }
        }
        //如果没有相同的key 那么将该key-value作为一个新的元素填入
        set[h].offerLast(new Pair(key, value));
    }

    /**
     * 获取对应key的value
     *
     * @param key
     * @return
     */
    public int get(int key) {
        //同样通过hash值找出对应索引的链表迭代器 迭代找出是否有与key值相同的元素 有就返回value 无就返回-1
        int h = hash(key);
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()) {
            Pair next = (Pair) iterator.next();
            if (next.getKey() == key) {
                return next.getValue();
            }
        }
        return -1;
    }

    /**
     * 移除元素
     *
     * @param key
     */
    public void remove(int key) {
        //同样通过hash值找出对应索引的链表迭代器 迭代找出是否有与key值相同的元素 有就在链表中移除该对象 无不做任何处理
        int h = hash(key);
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()) {
            Pair next = (Pair) iterator.next();
            if (next.getKey() == key) {
                set[h].remove(next);
                return;
            }
        }


    }

    static class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Pair() {

        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

class MyHashMap01 {
    private static Integer BASE = 768;
    private LinkedList[] set;

    public MyHashMap01() {
        set = new LinkedList[BASE];
        for (Integer i = 0; i < BASE; i++) {
            set[i] = new LinkedList<Pair>();
        }
    }

    public static int hash(int key) {
        return key % BASE;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator iterator = set[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = (Pair) iterator.next();
            if (next.getKey() == key) {
                next.setValue(value);
                return;
            }
        }
        set[hash].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator iterator = set[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = (Pair) iterator.next();
            if (next.getKey() == key) {
                return next.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator iterator = set[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = (Pair) iterator.next();
            if (next.getKey() == key) {
                set[hash].remove(next);
                return;
            }
        }
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}