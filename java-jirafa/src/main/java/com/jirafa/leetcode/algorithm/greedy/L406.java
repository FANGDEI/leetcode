package com.jirafa.leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });

        LinkedList<int[]> nums = new LinkedList<>();

        for(int[] ints:people){
            nums.add(ints[1],ints);
        }

        return nums.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] ints = new L406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        System.out.println("ss");
    }
}
