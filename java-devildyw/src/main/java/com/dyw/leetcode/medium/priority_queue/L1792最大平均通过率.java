package com.dyw.leetcode.medium.priority_queue;

import java.util.PriorityQueue;

/**
 * @author Devil
 * @since 2023-02-19-18:59
 */
@SuppressWarnings("all")
public class L1792最大平均通过率 {
    public static void main(String[] args) {
        System.out.println(new L1792最大平均通过率().maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5},{2,10}},4));
    }

    /**
     * 官方题解：
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20230219193241455.png"></img>
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        //优先队列中会存储 每次新增一个 extraStudents后这个班新增平均通过率（班级平均） 堆顶存储的是提升最大的班级信息
        //通过这个优先队列 我们就能每次取出堆顶元素来新增考生，直到考生添加完为止。
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
           long val1 = (long) (b[1]+1)*b[1]*(a[1]-a[0]);
           long val2 = (long) (a[1]+1)*a[1]*(b[1]-b[0]);

           if (val1==val2){
               return 0;
           }
           return val1<val2?1:-1;
        });

        for (int[] c : classes) {
            pq.offer(new int[]{c[0],c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            pq.offer(new int[]{arr[0]+1,arr[1]+1});
        }

        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            res+= 1.0*arr[0]/arr[1];
        }
        return res/classes.length;
    }

}
