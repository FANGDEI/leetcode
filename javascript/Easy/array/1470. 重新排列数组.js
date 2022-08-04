/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-08-03 10:15:26
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-08-03 10:18:35
 * @FilePath: \leetcode\javascript\Easy\array\1470. 重新排列数组.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
 var shuffle = function(nums, n) {
    let ret=[]
    for(let i=0;i<n;i++){
        ret.push(nums[i])
        ret.push(nums[i+n])
    }
    return ret
};