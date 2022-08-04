/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-26 18:47:23
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-26 21:56:28
 * @FilePath: \leetcode\javascript\Easy\array\643. 子数组最大平均数 I.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

任何误差小于 10-5 的答案都将被视为正确答案。
 */
var findMaxAverage = function(nums, k) {
    var max = Number.MIN_SAFE_INTEGER;
    var count = 0;
    for(var i=k-1; i<nums.length; i++) {
        for(var j=i; j>i-k; j--) {
            count += nums[j];
        }
        max = Math.max(count / k, max);
        count = 0;
    }
    return max;
};