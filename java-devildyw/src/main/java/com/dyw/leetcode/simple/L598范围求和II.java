package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @date 2022-05-21-14:15
 * <p>
 * 给你一个 m x n 的矩阵 M，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi]
 * 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * <p>
 * 在执行完所有操作后，计算并返回矩阵中最大整数的个数。
 */
@SuppressWarnings("all")
public class L598范围求和II {
    public static void main(String[] args) {
        new L598范围求和II().maxCount(3, 3, new int[][]{{2,2},{3,3}});
    }

    /**
     * 思路: 再ops数组中找到重复操作次数最多的行列  找到所有操作的交集即可 即最小行和列
     */
    public int maxCount(int m, int n, int[][] ops) {
        //初始化行和列的最小值
        int mina = m, minb = n;
        for (int[] op : ops) {
            //通过遍历 不断更新行列最小值
            mina = Math.min(mina,op[0]);
            minb = Math.min(minb,op[1]);
        }

        //mina * minb 就是最大整数的个数
        return mina * minb;
    }
}
