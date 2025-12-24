package main

import "fmt"

func main() {

	nums := []int{1, 3, 5, 6}
	target := 5
	result := searchInsert(nums, target)
	fmt.Println(result)
}

func searchInsert(nums []int, target int) int {
	var left = 0
	var right = len(nums) - 1
	var result = len(nums)
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] >= target {
			result = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return result
}

func searchInsertNew(nums []int, target int) int {
	var left = 0
	var right = len(nums) - 1
	var result = len(nums)
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] >= target {
			// target存在时 mid 等于他的下标 target不存在时 在大于target的第一个元素的位置上
			result = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return result
}
