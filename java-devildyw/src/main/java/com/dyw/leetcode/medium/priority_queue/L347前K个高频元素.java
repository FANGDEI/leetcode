package com.dyw.leetcode.medium.priority_queue;

import java.util.*;

/**
 * @author Devil
 * @since 2022-08-19-10:46
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
@SuppressWarnings("all")
public class L347前K个高频元素 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        //使用map存储计数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        //stream流 对set进行排序 去前k个元素组成一个数组
        return set.stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue()))
                .limit(k)
                .mapToInt(entry -> entry.getKey())
                .toArray();
    }


    /**
     * 优先队列 基于小顶堆实现
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent01(int[] nums, int k) {
        //首先使用 map 记录每个字母及其出现频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现频率
        //出现次数按从头到尾的顺序从小到大排，出现次数低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size()<k){ //小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                //如果当前队列中元素大于等于k个 那么比较当前元素的出现次数和队顶中的元素出现次数 如果当前元素大于对顶元素 则对顶元素出队将当前元素入队
                if (entry.getValue()>pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }

        //数组记录元素
        int[] ans = new int[k];
        for (int i = k-1; i>=0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
