/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-06-11 20:07:53
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-08 23:06:17
 * @FilePath: \leetcode\javascript\Easy\1317. 将整数转换为两个无零整数的和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 「无零整数」是十进制表示中 不含任何 0 的正整数。

// 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：

// A 和 B 都是无零整数
// A + B = n
// 题目数据保证至少有一个有效的解决方案。

// 如果存在多个有效解决方案，你可以返回其中任意一个。

/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function (n) {
    for (let i = 1; i < n; i++) {
        if (i.toString().indexOf('0') === -1 && (n - i).toString().indexOf('0') === -1) {
            return [i, n - i];
        }
    }
};
console.log(getNoZeroIntegers(11));