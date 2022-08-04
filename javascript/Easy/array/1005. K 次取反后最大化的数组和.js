/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-28 14:26:31
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-28 14:32:51
 * @FilePath: \leetcode\javascript\Easy\array\1005. K 次取反后最大化的数组和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

以这种方式修改数组后，返回数组 可能的最大和 。
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
 var largestSumAfterKNegations = function(nums, k) {
    for(let i=0;i<k;i++){
        nums=nums.sort((a,b)=>a-b)
        nums[0]=-nums[0]
    }
    return nums.reduce((pre,cur)=>pre+cur,0)
};