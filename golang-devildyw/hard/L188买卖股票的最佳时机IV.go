package main

func main() {

}

func maxProfitIV(k int, prices []int) int {
	// 有点像上一道题 不过是把2换成k了

	// 需要注意一个边界条件 那就是当k>=n/2的时候 因为买卖一次至少需要2天 如果超过就退化成了无限次买卖了 就跟买卖股票的最佳时机II 一样了
	n := len(prices)

	// if (k >= n/2) {
	//     //使用买卖股票最佳时机II的做法
	// }

	// dp[i][0] dp[i][1] 代表着第i笔买入或者交易的利润 因为会出现i-1的情况 所以这里增加一个位置来处理
	dp := make([][]int, k+1)
	for i := range k + 1 {
		dp[i] = make([]int, 2)
		// 初始化
		dp[i][0] = -prices[0]
	}
	dp[0][0] = 0

	// 状态转移方程
	for i := 1; i < n; i++ {
		// 随着第i天的变化 这k组不同状态的利润也会随之改变
		for j := 1; j <= k; j++ {
			// 第j笔买入时的利润 要么保持不变 要么就是上一笔交易的利润减去当前第i天的股票价格 取利润最大值
			dp[j][0] = max(dp[j][0], dp[j-1][1]-prices[i])
			// 第j笔卖出时的利润 要么保持不变 要么就是当前股票的价格+之前买入的利润 取最大值
			dp[j][1] = max(dp[j][1], prices[i]+dp[j][0])
		}
	}

	return dp[k][1]

}
