/*
 * @Author: Delta 2586784220@qq.com
 * @Date: 2022-07-04 11:53:15
 * @LastEditors: Delta 2586784220@qq.com
 * @LastEditTime: 2022-07-04 21:59:01
 * @FilePath: \leetcode\javascript\Dynamic programming\122. 买卖股票的最佳时机 II.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

// 返回 你能获得的 最大 利润 。
/**
 * @param {number[]} prices
 * @return {number}
 */
 var maxProfit = function(prices) {
    let length=prices.length
    let dp0=0,dp1=-prices[0]   //dp0是当天没有买卖，dp1是当天买入。然后每天计算利润，求最优解
    for(let i=1;i<length;i++){
        newdp0=Math.max(dp0,dp1+price[i])
        newdp1=Math.max(dp0-price[i],dp1)
        dp0=newdp0
        dp1=newdp1
    }
    return dp0
};
