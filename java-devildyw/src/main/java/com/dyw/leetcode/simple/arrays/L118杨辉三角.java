package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-14-10:20
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
@SuppressWarnings("all")
public class L118杨辉三角 {
    public static void main(String[] args) {
        System.out.println(new L118杨辉三角().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //如果是两边的元素 那么就填1
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    //如果是中间的元素 那么就按照题目的关系动态规划
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
