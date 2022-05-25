package com.dyw.leetcode.simple;

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
    private static final int BASE = 769;
    private LinkedList[] set;

    public MyHashMap() {
        set = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            set[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()){
            Pair next = (Pair) iterator.next();
            if (next.getKey()==key){
                next.setValue(value);
                return ;
            }
        }
        set[h].offerLast(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()){
            Pair next = (Pair) iterator.next();
            if (next.getKey()==key){
                return next.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator iterator = set[h].iterator();
        while (iterator.hasNext()){
            Pair next = (Pair) iterator.next();
            if (next.getKey()==key){
                set[h].remove(next);
                return;
            }
        }
    }

    public static int hash(int key){
        return key%BASE;
    }

    static class Pair{
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Pair(){

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