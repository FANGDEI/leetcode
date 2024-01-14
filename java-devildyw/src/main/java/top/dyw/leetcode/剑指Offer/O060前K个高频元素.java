package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Devildyw
 * @date 2023/08/07 12:20
 **/
@SuppressWarnings("all")
public class O060前K个高频元素 {

    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }

        int i = 0;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (i<k){
                priorityQueue.add(entry.getKey());
            }else{
                if (map.get(priorityQueue.peek())<entry.getValue()){
                    priorityQueue.poll();
                    priorityQueue.offer(entry.getKey());
                }
            }
            i++;
        }

        int[] array = priorityQueue.stream().mapToInt(c -> c).toArray();
        return array;

    }
}
