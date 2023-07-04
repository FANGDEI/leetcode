package com.feng.面试题.美团.M21年.第10套;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 22:30
 * @description: {}
 */
public class M3公司食堂 {
    /**
     * 通过优先级队列来做，哥们谢。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        PriorityQueue<Integer> queue0 = new PriorityQueue<>();
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        while (t-- > 0) {
            int n = scan.nextInt();//桌子数目
//            int[] nums = new int[n];
            scan.nextLine();
            String s = scan.nextLine();
//            System.out.println("s = " + s);
            for (int i = 0; i < n; i++) {
//                nums[i] =
                if (s.charAt(i) == '0') {
                    queue0.offer(i);
                } else if (s.charAt(i) == '1') {
                    queue1.offer(i);
                }

            }
            int M = scan.nextInt();
            scan.nextLine();
            String rens = scan.nextLine();
            for (int i = 0; i < M; i++) {
                if (rens.charAt(i) == 'F') {
                    Integer poll;
                    if (!queue0.isEmpty()) {
                        poll = queue0.poll();
                        queue1.offer(poll);
                    } else {
                        poll = queue1.poll();
                    }
                    System.out.println(poll + 1);

                } else {
                    //                    Integer poll = queue1.poll();
//                    System.out.println(poll + 1);
                    Integer poll;
                    if (!queue1.isEmpty()) {
                        poll = queue1.poll();
//                        queue0.offer(poll);
                    } else {
                        poll = queue0.poll();
                        queue1.offer(poll);
                    }
                    System.out.println(poll + 1);
                }
            }

            queue1.clear();
            queue0.clear();


        }
    }
}
