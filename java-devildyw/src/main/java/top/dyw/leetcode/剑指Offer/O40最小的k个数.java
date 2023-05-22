package top.dyw.leetcode.剑指Offer;

import top.dyw.nowcoder.top100.O45把数组排成最小的数;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Devildyw
 * @date 2023/05/09 21:11
 **/
@SuppressWarnings("all")
public class O40最小的k个数 {

    public static void main(String[] args) {
//        System.out.println(new O40最小的k个数().getLeastNumbers(new int[]{3, 2, 1}, 2));
        int[] ints = new O40最小的k个数().getLeastNumbers(new int[]{3, 2, 1}, 2);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];

        if (k==0) return res;
        //构建大顶堆 Java 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i<k){
                queue.offer(arr[i]);
            }
            if (i>=k&&arr[i]<queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

}
