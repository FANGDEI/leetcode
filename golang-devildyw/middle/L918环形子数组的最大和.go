package main

func main() {}

func maxSubarraySumCircular(nums []int) int {
	// 分为两种情况 一个是最大子数组没有跨越边界就能找到最大值 类似于最大子数组之和
	// 另一个情况是跨越边界的 那么这个子数组就相当于 数组减去中间一段 减去的可以逆向思维 总数组之和减去最小子数组之和

	if len(nums) == 0 {
		return 0
	}

	// 记录数组总和
	totalSum := 0

	// 记录没有跨越边界的最大子数组之和
	curMax := 0
	maxSum := nums[0]

	// 记录最小子数组之和
	curMin := 0
	minSum := nums[0]

	for i := range len(nums) {
		totalSum += nums[i]

		if curMax > 0 {
			curMax += nums[i]
		} else {
			curMax = nums[i]
		}
		maxSum = max(maxSum, curMax)

		if curMin < 0 {
			curMin += nums[i]
		} else {
			curMin = nums[i]
		}
		minSum = min(minSum, curMin)
	}

	// 特殊情况处理 当全为负数时 totalSum 和 minSum 相等 他们相减得到的是0 0肯定比全是负数情况下的 maxSum 大 所以这里处理一下
	if maxSum < 0 {
		return maxSum
	}

	return max(maxSum, totalSum-minSum)
}
