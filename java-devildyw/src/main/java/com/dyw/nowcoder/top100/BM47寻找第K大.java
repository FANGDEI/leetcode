package com.dyw.nowcoder.top100;

import java.util.PriorityQueue;
import java.util.regex.Pattern;

/**
 * @author Devil
 * @since 2023-01-31-12:03
 */
@SuppressWarnings("all")
public class BM47寻找第K大 {
    public static void main(String[] args) {
        System.out.println(new BM47寻找第K大().findKth(new int[]{10,10,9,9,8,7,5,6,4,3,4,2}, 12, 3));
    }

    //优先队列 小根堆 小根堆维护了一个根为堆中元素最小的一个堆，这样利用这个性质 我们可以维护一个k个较大元素的堆，而堆顶就是第k个最大的数
    public int findKth(int[] a, int n, int K) {
        // write code here
        //维护一个容量为k的小顶堆 这样当遍历完整个数组后 堆顶就是第k大的元素 (需要我们手动维护 因为优先队列会自动扩容)
        PriorityQueue<Integer> pq = new PriorityQueue<>(K);

        for (int i : a) {
//           //对于小根堆来说，只要没满就可以加入（不需要比较）；如果满了，才判断是否需要替换第一个元素
            if (pq.size()<K){
                pq.add(i);
            }else{
                // 在小根堆内，存储着K个较大的元素，根是这K个中最小的，如果出现比根还要大的元素，说明可以替换根
                if (i>pq.peek()){
                    pq.poll();//高个里面挑矮个
                    pq.add(i);
                }
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
