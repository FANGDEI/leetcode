package main

func main() {

}

func rob(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	dp := make([]int, len(nums)+1)
	dp[0] = 0
	dp[1] = nums[0]
	// dp[i] 记录到第i间屋子偷窃的最高金额
	for i := 2; i <= len(nums); i++ {
		// 既然要隔间屋才能偷 那么在递推的时候就比较是偷这间屋子呢（需要算上前间屋子的钱）还是不偷这间保留上间屋子的钱 谁赚的多呢
		dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
	}
	return dp[len(nums)]
}
