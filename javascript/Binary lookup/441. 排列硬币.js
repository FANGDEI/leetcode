/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-13 16:22:17
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-13 16:38:11
 * @FilePath: \leetcode\javascript\Binary lookup\441. 排列硬币.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 */

/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function (n) {
    let res = 0
    while (1) {
        if (res * (res + 1) / 2 <= n && (res + 1) * (res + 2) / 2 > n)
            return res
        else {
            res++
        }
    }
};