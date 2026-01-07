package main

func main() {

}

func maxProfitFroze(prices []int) int {

	// 在买卖股票II的基础上增加了一个冷冻期的状态
	n := len(prices)
	dp := make([][]int, n)
	for i := range n {
		dp[i] = make([]int, 3)
	}

	// 初始化
	// dp[i][0] 表示在第i天持有股票的利润
	dp[0][0] = -prices[0]
	// dp[i][1] 表示在第i天卖出股票的利润
	dp[0][1] = 0 //第0天不吃有股票 没办法卖所以是0
	// dp[i][2] 标识在第i天休息的利润
	dp[0][2] = 0 //第i天休息那就不卖呗

	// 状态转移
	for i := 1; i < n; i++ {
		// 第i天持有股票的利润 Max(前一天持有股票的利润， 前一天是冷静期今天买股票的价格)
		dp[i][0] = max(dp[i-1][0], dp[i-1][2]-prices[i])

		// 第i天卖出股票的利润 前一天持有股票利润+今天卖出股票的利润 dp[i][1] 是一个瞬时态 他没办法保留前一天的sold状态 因为如果你前一天sold 那么今天sold必须持有 但是按照题意今天应该是冷冻期 所以这个知识一个瞬时的状态 卖出的利润 被保留在了dp[i][2]中了
		dp[i][1] = dp[i-1][0] + prices[i]

		// 第i天冷静期是的股票利润 可以是昨天休息期的利润 也可以是昨天刚买完今天休息的利润的最大值
		dp[i][2] = max(dp[i-1][2], dp[i-1][1])
	}

	return max(dp[n-1][1], dp[n-1][2])
}
