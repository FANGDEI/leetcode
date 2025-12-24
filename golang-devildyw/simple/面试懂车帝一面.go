package main

import (
	"fmt"
	"math"
)

func main() {
	simpleTest([]int{-3, -1, 2, 5, 33, 7, 9})
}

// [-3,-1, 2, 5, 33, 7, 9]
// 在i<j下
// 求max(a[j] - a[i])
func simpleTest(nums []int) {
	minVal := nums[0]
	res := math.MinInt32
	for i := 1; i < len(nums); i++ {
		res = max(res, nums[i]-minVal)
		if nums[i] < minVal {
			minVal = nums[i]
		}
	}

	fmt.Println(res)
}
