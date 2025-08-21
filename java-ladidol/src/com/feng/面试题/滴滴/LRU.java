package com.feng.面试题.滴滴;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

  //实现一个Map.Map有一个最大容量cap.如果超过cap。基于LRU淘汰一个Key。
  //Map有两个方法Get/Set
  //例如Set(1, 100)
  //时间复杂度 O1
  public static void main(String[] args) {
    LRUMap lruMap = new LRUMap(5);
    lruMap.put(1,100);
    lruMap.put(2,100);
    lruMap.get(1);
    lruMap.put(3,100);
    lruMap.put(4,100);
    lruMap.put(5,100);
    lruMap.put(6,100);
    System.out.println("lruMap = " + lruMap);
  }



}

class LRUMap extends LinkedHashMap<Integer,Integer> {
  private int size;

  public LRUMap(int size){
    super(size,0.75f,true);
    this.size = size;
  }

  @Override
  public boolean removeEldestEntry(Map.Entry entry){
    return size() > size;
  }

}