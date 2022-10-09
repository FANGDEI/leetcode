package com.dyw.leetcode.algorithm.回溯.template;

/**
 * 回溯模板
 *
 * @author Devil
 * @since 2022-10-09-12:32
 */
public class BackTracking {

    void backtracking(/*参数*/){
        if (/*终止条件*/true){
            /*存放结果*/
            return;
        }

        for (int i = 0; i<Integer.MAX_VALUE;){ /*选择：本层集合中元素（数中节点孩子的数量就是集合的大小）*/
            /*处理节点*/
            backtracking(/*路径，选择列表*/);//递归
            /*回溯，撤销处理结果*/
        }
    }
}
