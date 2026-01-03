package main

import "math"

func main() {

}

// 从前往后退
func lengthOfLIS(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}

	dp := make([]int, n)
	maxLen := math.MinInt32
	for i := 0; i < n; i++ {
		// 初始状态为 1 因为每个元素自身都可以形成一个递增子序列
		dp[i] = 1
		for j := 0; j < i; j++ {
			// 如果当前元素大于之前的元素，那么就可以添加在那个元素后面 可以进行状态转移
			if nums[i] > nums[j] {
				// dp[j] + 1 因为 nums[i] 可以添加到该元素后面 所以长度加1
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		maxLen = max(dp[i], maxLen)
	}

	return maxLen

}

// 从当前往后
func lengthOfLISNew(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}

	dp := make([]int, n)
	for i := range n {
		// 初始状态为 1 因为每个元素自身都可以形成一个递增子序列
		dp[i] = 1
	}

	maxLen := math.MinInt32
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			// 跟上面的做法完全反过来
			if nums[j] > nums[i] {
				dp[j] = max(dp[j], dp[i]+1)
			}
		}
		maxLen = max(dp[i], maxLen)
	}

	return maxLen

}
