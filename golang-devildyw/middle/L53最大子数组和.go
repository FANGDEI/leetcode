package main

func main() {}

func maxSubArray(nums []int) int {
	maxSum := nums[0]
	// 前缀和
	currentSum := 0

	for i := range len(nums) {
		// 如果前缀和是负数 则视为累赘丢弃 从0开始
		if currentSum > 0 {
			currentSum += nums[i]
		} else {
			currentSum = nums[i]
		}
		maxSum = max(currentSum, maxSum)
	}
	return maxSum
}
