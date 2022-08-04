/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-30 15:43:07
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-30 17:11:32
 * @FilePath: \leetcode\javascript\Easy\array\1260. 二维网格迁移.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

每次「迁移」操作将会引发下述活动：

位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
 */
/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
 var shiftGrid = function (grid, k) {
    let m = grid.length, n = grid[0].length
    while (k > 0) {
        let last = grid[m - 1][n - 1]
        for (let i = m - 1; i >= 0; i--) {
            for (let j = n - 1; j >= 0; j--) {
                if (j !== 0) {
                    grid[i][j] = grid[i][j - 1]
                }
                else if (j == 0 && i == 0) {
                    grid[i][j] = last
                }
                else {
                    grid[i][j] = grid[i - 1][n - 1]
                }
            }
        }
        k--
    }
    return grid
};