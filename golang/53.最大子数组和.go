package golang

// 贪心
// 当当前 sum < 0 时 就不会存在下一个 nums + sum > 0 + sum
// 直接将 sum = 0 即可
func maxSubArray(nums []int) int {
	res, sum := -0x7fffffff, 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		res = Max(res, sum)
		if sum < 0 {
			sum = 0
		}
	}
	return res
}

// dp
// dp[i] 代表 i 下标的连续子数组的最大和
// 状态转移方程: dp[i] = max(dp[i - 1] + nums[i], dp[i])
//func maxSubArray(nums []int) int {
//	dp := make([]int, len(nums))
//	dp[0] = nums[0]
//	res := dp[0]
//	for i := 1; i < len(nums); i++ {
//		dp[i] = nums[i]
//		if dp[i-1]+nums[i] > dp[i] {
//			dp[i] = dp[i-1] + nums[i]
//		}
//		if dp[i] > res {
//			res = dp[i]
//		}
//	}
//	return res
//}

// dp 空间优化
// 因为 dp[i] 的值只与 dp[i - 1] 与 nums[i] 有关
// 所以我们可以直接使用原 nums 数组
//func maxSubArray(nums []int) int {
//	res := nums[0]
//	for i := 1; i < len(nums); i++ {
//		if nums[i]+nums[i-1] > nums[i] {
//			nums[i] = nums[i] + nums[i-1]
//		}
//		if nums[i] > res {
//			res = nums[i]
//		}
//	}
//	return res
//}
