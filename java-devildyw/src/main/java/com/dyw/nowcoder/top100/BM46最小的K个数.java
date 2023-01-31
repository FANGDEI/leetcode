package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Devil
 * @since 2023-01-31-11:56
 */
@SuppressWarnings("all")
public class BM46最小的K个数 {

    public static void main(String[] args) {
        System.out.println(new BM46最小的K个数().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

    /**
     * 大顶堆 优先队列
     * 利用大顶堆的特性 根为堆内最大的元素，利用这个特性我们可以维护一个容量为k的大顶堆，包含k个较小元素 而堆顶是整个堆最大的值 利用它来逐步替换堆内的元素
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(o1,o2)->o2-o1); //大顶堆 手动维护容量
        ArrayList<Integer> result = new ArrayList<>();
        //大顶堆维护k个较小的元素
        for (int i = 0; i < input.length; i++) {
            if (pq.size()<k){
                //当容量小于k时直接加入堆中
                pq.add(input[i]);
            }else{
                //大顶堆中保存着数组中较小的k个值，如果出现堆顶元素大于当前遍历元素，那么堆顶元素出队。
                //一旦有元素小于堆顶元素说明可以替换根
                if (input[i]<pq.peek()){
                    pq.poll();//矮个里面拔高个
                    pq.add(input[i]);
                }
            }
        }

        while (k-->0){
            result.add(pq.poll());
        }

        return result;
    }
}
