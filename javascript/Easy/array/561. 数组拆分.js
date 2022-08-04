/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-30 10:51:29
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-30 15:18:33
 * @FilePath: \leetcode\javascript\Easy\array\561. 数组拆分.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。

返回该 最大总和 。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var arrayPairSum = function(nums) {
    let ret=0
    nums=nums.sort((a,b)=>a-b)
    for(let i=0;i<nums.length;i+=2){
        ret+=nums[i]
    }
    return ret
};