package main

import "math"

func main() {}

func findPeakElement(nums []int) int {
	n := len(nums)

	get := func(i int) int {
		if i == -1 || i == n {
			return math.MinInt64
		}
		return nums[i]
	}

	left := 0
	right := n - 1
	//二分
	for {
		mid := (right + left) / 2
		if get(mid-1) < get(mid) && get(mid) > get(mid+1) {
			// 符合题意 返回
			return mid
		}
		if get(mid) < get(mid+1) {
			// 递增 那么最大值一定在右边 所以我们向右找
			left = mid + 1
		} else {
			// 相反
			right = mid - 1
		}
	}
}

/*
*
O(n)做法
*/
func findPeakElementOn(nums []int) int {
	n := len(nums)

	get := func(i int) int {
		//题目要求
		if i == -1 || i == n {
			return math.MinInt64
		}
		return nums[i]
	}

	for i := 0; i < n; i++ {
		if get(i) > get(i-1) && get(i) > get(i+1) {
			return i
		}
	}
	return -1
}
