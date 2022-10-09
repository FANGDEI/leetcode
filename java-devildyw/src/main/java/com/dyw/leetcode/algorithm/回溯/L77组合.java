package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 *
 * @author Devil
 * @since 2022-10-09-12:30
 */
@SuppressWarnings("all")
public class L77组合 {

    public static void main(String[] args) {

    }


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 经典回溯问题
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        //这里startIndex从1开始
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        /*
        1. 已经选择的元素个数：path.size();

        2. 还需要的元素个数为: k - path.size();

        3. 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
         */
        //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
        for (int i = startIndex; i <= n-(k-path.size())+1; i++) { //优化的地方
            path.add(i);
            //下一层 i+1
            combineHelper(n, k, i + 1);
            path.removeLast();
        }

//        for (int i = startIndex; i <= n; i++) {
//            path.add(i);
//            //下一层 i+1
//            combineHelper(n, k, i + 1);
//            path.removeLast();
//        }

    }
}
