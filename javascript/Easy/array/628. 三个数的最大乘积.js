/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-04 09:29:16
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-04 09:32:27
 * @FilePath: \leetcode\javascript\Easy\array\628. 三个数的最大乘积.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
/**
 * @param {number[]} nums
 * @return {number}
 */
 var maximumProduct = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
};