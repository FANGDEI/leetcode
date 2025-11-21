package main

import "math"

func minSubArrayLen(target int, nums []int) int {
	result := math.MaxInt32
	sum := 0
	left := 0

	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		for sum >= target {
			result = min(result, i-left+1)
			sum -= nums[left]
			left++
		}
	}

	if result == math.MaxInt32 {
		return 0
	}

	return result
}
