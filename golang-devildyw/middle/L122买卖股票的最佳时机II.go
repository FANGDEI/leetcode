package main

import "math"

func main() {

}

func maxProfit(prices []int) int {
	// 可以多次买卖股票 但同一时刻最多只能持有一股（也可以不持有）
	// 在这种情况下想要获得最大利润 可以把问题拆解为递推状态转移 最大利润需要由前面的最大利润得到 也就是转化为了最小子问题最优解
	// 在一天里 你可以选择买出股票 或者买入股票 也可以保持原样

	//根据上面的信息我们可以确定状态了
	// dp[i][0] 为第i天不持有股票的利润
	// dp[i][1] 为第i天持有股票的利润
	var (
		dp [][2]int = make([][2]int, len(prices))
	)
	dp[0][0] = 0
	dp[0][1] = -prices[0]

	for i := 1; i < len(prices); i++ {
		dp[i][0] = int(math.Max(float64(dp[i-1][0]), float64(prices[i]+dp[i-1][1])))
		dp[i][1] = int(math.Max(float64(dp[i-1][1]), float64(dp[i-1][0]-prices[i])))
	}

	return dp[len(prices)-1][0]
}
