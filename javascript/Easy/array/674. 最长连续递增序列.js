/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-26 18:20:33
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-26 18:46:45
 * @FilePath: \leetcode\javascript\Easy\array\674. 最长连续递增序列.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var findLengthOfLCIS = function(nums) {
    if (nums.length < 1) { return 0 }
  
    let max = 1
    let len = 1
  
    for (let i = 1; i < nums.length; i ++) {
      if (nums[i] > nums[i - 1]) {
        len++
        max = Math.max(max, len)
      } else {
        len = 1
      }
    }
  
    return max
  };
   