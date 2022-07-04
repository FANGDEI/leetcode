/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-04 09:46:32
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-04 10:02:58
 * @FilePath: \leetcode\javascript\Dynamic programming\面试题 17.16. 按摩师.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

/**动态规划，dp[i]为长度为i的时候的最优解，则nums长度为0和1的时候最优解是确定的，分别为nums[0]和Math.max(nums[0],nums[1]),
对于i=2，对于最后一个预约有两种情况：
选择这个预约，则不能选i-1这个预约，最优解dp[i] = dp[i - 2] + nums[i]
不选这个预约，则这时候最优解dp[i] = dp[i - 1]
真正的最优解选两个之间大的一个即可
 * @param {number[]} nums
 * @return {number}
 */
 var massage = function(nums) {
    let length=nums.length
    if(length==0) return []
    // 创建dp数组
    let dp=[nums[0],Math.max(nums[0],nums[1])]
    // 遍历找出每个dp的最大值
    for(let i=2;i<length;i++){
        dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1])
    }
    return dp[length-1]
};