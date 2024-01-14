package top.dyw.leetcode.剑指Offer;

import java.util.PriorityQueue;

/**
 * @author Devildyw
 * @date 2023/08/06 13:19
 **/
@SuppressWarnings("all")
public class O059数据流中的第K大元素 {

    public static void main(String[] args) {
//        [3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]
        KthLargest largest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(largest.add(3));
        System.out.println(largest.add(5));
        System.out.println(largest.add(10));
        System.out.println(largest.add(9));
        System.out.println(largest.add(4));
    }

    //找到第k打的元素 小顶堆 维护小顶堆，只要知道比堆顶大的元素就加入 维护堆的大小为7 这样最后堆顶的元素就是最大元素最小的排第7
    static class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int size;

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>();//默认小顶堆
            size = k;

            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    priorityQueue.offer(nums[i]);
                } else {
                    if (priorityQueue.peek() < nums[i]) {
                        priorityQueue.poll();
                        priorityQueue.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (priorityQueue.size()>=size){
                if (priorityQueue.peek()<val){
                    priorityQueue.poll();
                    priorityQueue.offer(val);
                }
            }else{
                priorityQueue.add(val);
            }

            return priorityQueue.peek();
        }
    }
}
