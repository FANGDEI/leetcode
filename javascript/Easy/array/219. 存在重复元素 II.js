/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-11 15:23:00
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-11 15:31:26
 * @FilePath: \leetcode\javascript\Easy\array\219. 存在重复元素 II.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%A
 */
/* 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
 var containsNearbyDuplicate = function(nums, k) {
    for(let i=0;i<nums.length;i++){
        for(let f=i+1;f<nums.length;f++){
            if(nums[i]==nums[f]&&f-i<=k){
                return true
            }
        }
    }
    return false
};
console.log(contains);