/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-01 16:56:03
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-01 17:17:27
 * @FilePath: \leetcode\javascript\Easy\array\908. 最小差值 I.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
nums 的 分数 是 nums 中最大和最小元素的差值。 
在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
 var smallestRangeI = function(A, K) {
    //拿到最大值与最小值
    let min = Math.min(...A)
    let max = Math.max(...A)
    //如果最小值加K大于等于最大值减K，直接返回0
    if(min + K >= max - K){
        return 0 
    }
    //返回最大值减最小值减2K
    return max  - min - 2 * K
};