/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._11模拟;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/12 11:49
 */
public class h146LRU缓存 {

  //  实现说明：
  //  1、用 Node 类表示双向链表节点。
  //  2、用 HashMap 存储 key 到节点的映射。
  //  3、新访问或插入的节点移动到链表头部。
  //  4、超容量时，移除链表尾部节点。
//  class LRUCache11 {
//
//    class Node {
//      int key, value;
//      Node prev, next;
//      Node(int k, int v) { key = k; value = v; }
//    }
//
//    private int capacity;
//    private HashMap<Integer, Node> map;
//    private Node head, tail;
//
//    public LRUCache11(int capacity) {
//
//    }
//
//    public int get(int key) {
//
//    }
//
//    public void put(int key, int value) {
//
//    }
//  }

  class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
      super(capacity, 0.75f, true); // accessOrder = true
      this.capacity = capacity;
    }

    public int get(int key) {
      return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
      super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }
  }


}
