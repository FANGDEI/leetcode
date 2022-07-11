/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-11 15:51:31
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-11 15:57:58
 * @FilePath: \leetcode\javascript\Easy\array\268. 丢失的数字.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var missingNumber = function(nums) {
    nums.sort((a,b)=>a-b)
    for(let i=0;i<nums.length;i++){
        if(nums[i]!=i){
            return i
        }
    }
    return nums.length
};
console.log(missingNumber([1,3,0]));