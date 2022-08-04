/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-26 16:58:37
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-26 17:08:11
 * @FilePath: \leetcode\javascript\单调队列\918. 环形子数组的最大和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/* 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
 var maxSubarraySumCircular = function(nums) {
    for(let i=0;i<nums.length-1;i++){
        for(let y=i+1;y<nums.length+1;y++){
            let arr=nums.slice(i,y)
        }
    }
};