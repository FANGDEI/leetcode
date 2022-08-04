/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 15:04:33
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 22:45:33
 * @FilePath: \leetcode\javascript\Easy\array\598. 范围求和 II.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。

在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 */
/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} ops
 * @return {number}
 */
 var maxCount = function(m, n, ops) {
    let mina = m, minb = n;
    for (const op of ops) {
        mina = Math.min(mina, op[0]);
        minb = Math.min(minb, op[1]);
    }
    return mina * minb;
};
