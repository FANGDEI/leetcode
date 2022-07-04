/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-04 09:19:08
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-04 09:42:45
 * @FilePath: \leetcode\javascript\Dynamic programming\剑指 Offer 42. 连续子数组的最大和.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

// 剑指 Offer 42. 连续子数组的最大和
// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

// 要求时间复杂度为O(n)。
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
    if (nums.length === 0) {
        return 0;
    }
    // 创建dp数组
    const dp = new Array(nums.length);
    dp[0] = nums[0];
    let max = nums[0];
    let sum = nums[0];
    for (let i = 1; i < dp.length; i++) {
        // 如果当前值加上累计值比当前值大，则把当前值加入累计值
        if (nums[i] + sum > nums[i]) {
            dp[i] = dp[i - 1] + nums[i];
            sum += nums[i];
        } else {
            // 否则，重新设置累计为当前值
            sum = nums[i]
            dp[i] = nums[i];
        }
        max = Math.max(max, dp[i]);
    }
    return max;
};
/* 状态转移方程
f(i)=max{f(i−1)+nums[i],nums[i]} */
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int[] dp = new int[nums.length];
//         dp[0]=nums[0];
//         for(int j = 1;j<nums.length;j++){
//             if(dp[j-1]>0){
//                 dp[j] = dp[j-1]+nums[j];
//             }else{
//                 dp[j] = nums[j];
//             }
//         }
//         int max = Integer.MIN_VALUE;
//         for(int i = 0;i<dp.length;i++){
//             if(dp[i]>max)
//                 max = dp[i];
//         }
//         return max;
//     }
// }
var maxSubArray = function(nums) {
    let max = nums[0] // 最大值从第一位开始
    for (let i = 1; i < nums.length; i++) {
        nums[i] += Math.max(nums[i - 1], 0)
        max = Math.max(nums[i], max)
    }
    return max
};
