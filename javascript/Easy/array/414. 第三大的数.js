/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-26 17:53:57
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-26 17:59:06
 * @FilePath: \leetcode\javascript\Easy\array\414. 第三大的数.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var thirdMax = function(nums) {
    nums=nums.sort((a,b)=>b-a)
    let arr=nums.filter((item,index)=>item!=nums[index-1])
    return arr[2]||arr[arr.length-1]
};