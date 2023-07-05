package top.dyw.leetcode.剑指Offer;

import java.util.*;

/**
 * @author Devildyw
 * @date 2023/07/05 11:30
 **/
@SuppressWarnings("all")
public class OII030插入删除和随机访问都是O1的容器 {

    public static void main(String[] args) {

    }

    class RandomizedSet {
        List<Integer> list;
        
        HashMap<Integer,Integer> map;
        Random random;
        
        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new LinkedList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            int index = list.size();
            list.add(val);
            map.put(val,index);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            Integer index = map.get(val);
            //为了保证时间复杂度为O(1) 所以这里获取到末尾元素，让后与要被删除的元素做覆盖，如果被删元素已经为末尾元素，我们也会删除
            //获取末尾元素
            Integer last = list.get(list.size() - 1);
            //覆盖
            list.set(index,last);
            map.put(last,index);
            //删除末尾元素
            list.remove(list.size()-1);
            //map 删除元素
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}
