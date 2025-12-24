package main

func main() {
	println(maxSubArray([]int{-1, -2, -3, -4, -5}))

}

//func maxSubArray(nums []int) int {
//	maxSum := nums[0]
//	// 前缀和
//	currentSum := 0
//
//	for i := range len(nums) {
//		// 如果前缀和是负数 则视为累赘丢弃 从0开始
//		if currentSum > 0 {
//			currentSum += nums[i]
//		} else {
//			currentSum = nums[i]
//		}
//		maxSum = max(currentSum, maxSum)
//	}
//	return maxSum
//}

func maxSubArray(nums []int) int {
	// 避免设置0 万一全为负数怎么办
	result := nums[0]

	// 前缀和
	curMax := 0

	for i := 0; i < len(nums); i++ {
		// 如果当前前缀和小于0 那么视它为累赘 丢弃
		if curMax > 0 {
			curMax += nums[i]
		} else {
			curMax = nums[i]
		}
		result = max(result, curMax)
	}
	return result
}
