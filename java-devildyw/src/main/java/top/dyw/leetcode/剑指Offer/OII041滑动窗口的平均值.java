package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/17 13:39
 **/
@SuppressWarnings("all")
public class OII041滑动窗口的平均值 {

    public static void main(String[] args) {

    }

    /**
     * 自己的笨方法
     */
//    static class MovingAverage {
//        ArrayList<Integer> list; //前缀和数组
//        int k = 0;
//
//        /** Initialize your data structure here. */
//        public MovingAverage(int size) {
//            list = new ArrayList<>(size);
//            k = size;
//        }
//
//        public double next(int val) {
//            if (list.size()==0){
//                list.add(val);
//                return val/1.0;
//            }
//
//            list.add(list.get(list.size()-1)+val);
//            //计算窗口内的值
//            if (list.size()<=k){
//                Integer sum = list.get(list.size() - 1);
//                return (double) sum / list.size();
//            }else{
//                int sum = list.get(list.size() - 1) - list.get(list.size() - k - 1);
//                return (double) sum / k;
//            }
//        }
//    }

    class MovingAverage {
        Deque<Integer> queue;
        int size;

        int sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            queue = new ArrayDeque<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            if (queue.size()==size){
                sum-=queue.poll();
            }

            queue.offer(val);
            sum+=val;
            return (double)sum/queue.size();
        }
    }
}
