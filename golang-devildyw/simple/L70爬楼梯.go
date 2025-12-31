package main

func main() {

}

func climbStairs(n int) int {
	if n <= 2 {
		return n
	}
	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		// 跳跃到第i个位置 dp[i-2] 到这个位置只有1种方法 跳两步 因为跳一步再跳一步已经被 dp[i-1]包含了 i-2的位置跨一步步就到i-1了嘛 已经包含了
		//dp[i-1] 到这个位置有1种方法
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}
