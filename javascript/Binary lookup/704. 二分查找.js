/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-13 16:37:46
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-13 16:42:58
 * @FilePath: \leetcode\javascript\Binary lookup\704. 二分查找.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var search = function(nums, target) {
    let left=0,right=nums.length-1
    while(left<=right){
        let middle=Math.floor((left+right)/2)
        if(nums[middle]==target) return middle
        else if(nums[middle]<target)   left=middle+1
        else right=middle-1
    }
    return -1
};