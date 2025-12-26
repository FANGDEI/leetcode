package main

import "fmt"

func main() {
	fmt.Printf("%v", searchRangeNew([]int{1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10}, 2))
}

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}

	left := 0
	right := len(nums) - 1

	first := -1
	second := -1
	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] >= target {
			first = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	if first != -1 && nums[first] != target {
		return []int{-1, -1}
	}

	left = 0
	right = len(nums) - 1
	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] > target {
			right = mid - 1
		} else {
			second = mid
			left = mid + 1
		}
	}

	if second != -1 && nums[second] != target {
		return []int{-1, -1}
	}

	return []int{first, second}
}

func searchRangeNew(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}

	left := 0
	right := len(nums) - 1
	first := -1
	second := -1

	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] >= target {
			first = mid
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	if first != -1 && nums[first] != target {
		return []int{-1, -1}
	}

	left = 0
	right = len(nums) - 1
	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] <= target {
			second = mid
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	if second != -1 && nums[second] != target {
		return []int{-1, -1}
	}

	return []int{first, second}
}
