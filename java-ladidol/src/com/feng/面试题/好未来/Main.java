package com.feng.面试题.好未来;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/10/21 20:21
 * @description: {}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), k = scan.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = scan.nextInt();
        }
        //5 4
        //1 2 3 4 5
        //3 5 7 9 11
//        int index1 = n - 1, index2 = n - 1;
//        for (int i = 0; i < k; i++) {
//            int
//
//
//        }
        List<Integer> maxK = getMaxK(nums1, nums2, k, n);
        for (int i = k - 1; i > 0; i--) {
            System.out.print(maxK.get(i) + " ");
        }
        System.out.print(maxK.get(0));


    }

    public static List<Integer> getMaxK(int[] a, int[] b, int k, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = n - 1; i >= n - k - 1; i--) {
            for (int j = n - 1; j >= n - k - 1; j--) {

                maxHeap.offer(a[i] + b[j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }

            }
        }
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            res.add(maxHeap.poll());
        }
        return res;
    }


}