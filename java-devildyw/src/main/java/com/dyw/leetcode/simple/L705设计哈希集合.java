package com.dyw.leetcode.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Devil
 * @date 2022-05-25-11:26
 *
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 *
 */
@SuppressWarnings("all")
public class L705设计哈希集合 {
    public static void main(String[] args) {

    }
}

/**
 * 链地址法实现一个简单的hash表
 */
class MyHashSet {
    private static final int BASE = 769;
    //创建一个linkedList用于拉链法
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            if (next==key){
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            if (next==key){
                data[h].remove(next);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            if (next==key){
                return true;
            }
        }
        return false;
    }

    private static int hash(int key){
        return key%BASE;
    }
}