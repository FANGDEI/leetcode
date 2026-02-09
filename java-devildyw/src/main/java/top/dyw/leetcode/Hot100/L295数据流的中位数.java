package top.dyw.leetcode.Hot100;
import java.util.*;
public class L295数据流的中位数 {
    class MedianFinder {
        //维护两个堆 默认小顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        public MedianFinder() {

        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            while(minHeap.size()> maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
                return (double)maxHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
