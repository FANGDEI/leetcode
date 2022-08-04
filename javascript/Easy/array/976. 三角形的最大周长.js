/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 14:10:33
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 14:20:00
 * @FilePath: \leetcode\javascript\Easy\array\976. 三角形的最大周长.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如
果不能形成任何面积不为零的三角形，返回 0。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var largestPerimeter = function(A) {
    A.sort((a, b) => a - b);
    for (let i = A.length - 1; i >= 2; --i) {
        if (A[i - 2] + A[i - 1] > A[i]) {
            return A[i - 2] + A[i - 1] + A[i];
        }
    }
    return 0;
};