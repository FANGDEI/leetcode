package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-02-07-14:14
 */
@SuppressWarnings("all")
public class BM55没有重复项数字的全排列 {

    public static void main(String[] args) {
        System.out.println(new BM55没有重复项数字的全排列().permute(new int[]{0,1}));
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        backTracking(num, 0);
        return result;
    }

    private void backTracking(int[] num, int index) {
        if (path.size() == num.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (path.contains(num[i])) {
                continue;
            }
            path.add(num[i]);
            //继续往后找
            backTracking(num, i + 1);
            //回溯
            path.removeLast();
        }

    }
}

