/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-01 11:04:57
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-01 16:51:43
 * @FilePath: \leetcode\javascript\Easy\array\867. 转置矩阵.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 */
/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function (matrix) {
    let row = matrix.length, col = matrix[0].length, res = []
    for (let i = 0; i <col; i++) {
        let ret = [],coll = 0
        while (coll< row) {
            ret.push(matrix[coll][i])
            coll++
        }
        res.push(ret)
    }
    return res
};
console.log(transpose([[1, 2, 3], [4, 5, 6], [7, 8, 9]]));