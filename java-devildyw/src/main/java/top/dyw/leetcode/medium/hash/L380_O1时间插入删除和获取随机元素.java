package top.dyw.leetcode.medium.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Devildyw
 * @date 2023/07/16 10:58
 **/
@SuppressWarnings("all")
public class L380_O1时间插入删除和获取随机元素 {

    class RandomizedSet {

        ArrayList<Integer> list;

        HashMap<Integer,Integer> map;

        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)){
                return false;
            }
            int index = map.get(val);
            int last = list.get(list.size()-1);
            list.set(index,last);
            map.put(last,index);
            list.remove(list.size()-1);
            map.remove(val); //这里要先添加再删除，否则会出错 比如只有一个元素的时候
            return true;

//            if (map.containsKey(val)){
//                Integer index = map.get(val);
//                Integer last = list.get(list.size() - 1);
//                list.set(index,last);
//                list.remove(list.size()-1);
//                map.remove(val);
//                map.put(last,index);
//                return true;
//            }
//            return false;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
