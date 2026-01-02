package main

import "math"

func main() {

}

func coinChange(coins []int, amount int) int {

	// dp[i] 表示要组成 i 金额的最少金币数量
	dp := make([]int, amount+1)
	for i := 1; i <= amount; i++ {
		dp[i] = math.MaxInt32
	}
	// i=0时为0
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		for j := 0; j < len(coins); j++ {
			// 硬币金额得小于等于目标值才能参与兑换 否则面值太大了算不了
			if coins[j] <= i {
				// 轮流与F(i-coins[j])+1进行对比 因为F(i) 就等于 当前金额-coins[j] 的最小硬币数量再加上 coins[j]这一个硬币得到 通过这种递推公式最终得到dp[amount]的最小硬币数量
				dp[i] = min(dp[i-coins[j]]+1, dp[i])
			}
		}
	}

	if dp[amount] == math.MaxInt32 {
		return -1
	}

	return dp[amount]

}
