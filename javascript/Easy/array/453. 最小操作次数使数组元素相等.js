/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-29 09:35:56
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-29 09:45:10
 * @FilePath: \leetcode\javascript\Easy\array\453. 最小操作次数使数组元素相等.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var minMoves = function(nums) {
    const minNum = Math.min(...nums);
    let res = 0;
    for (const num of nums) {
        res += num - minNum;
    }
    return res;
};