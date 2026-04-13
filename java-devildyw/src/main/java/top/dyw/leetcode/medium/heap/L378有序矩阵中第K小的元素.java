package top.dyw.leetcode.medium.heap;

import java.util.*;

public class L378有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0; i<Math.min(m, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k>0 && !minHeap.isEmpty()) {
            k--;
            int[] cur = minHeap.poll();
            int i = cur[0];
            int j = cur[1];
            if (k==0) {
                return matrix[i][j];
            }

            if (j + 1< n) {
                minHeap.offer(new int[]{i, j+1});
            }
        }
        return -1;
    }
}
