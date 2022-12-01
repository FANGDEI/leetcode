var coinChange = function (coins, amount) {
    let dp = new Array(amount + 1).fill(Infinity);//初始化dp数组
    dp[0] = 0;//面额0只需要0个硬币兑换

    for (let i = 1; i <= amount; i++) {//循环面额
        for (let coin of coins) {//循环硬币数组
            if (i - coin >= 0) {//当面额大于硬币价值时
                //dp[i - coin]： 当前面额i减当前硬币价值所需要的最少硬币
                //dp[i] 可由 dp[i - coin] + 1 转换而来
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    return dp[amount] === Infinity ? -1 : dp[amount];//如果dp[amount] === Infinity，则无法兑换
};
