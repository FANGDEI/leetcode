package main

func main() {
	println(searchNew([]int{4, 5, 6, 7, 0, 1, 2, 3}, 0))
}

func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1
	//通过不断对数组2分 一定会有一个有序数组（另一半可能也有序）（针对选转数组）
	// 首先对有序数组判断我们的target在不在这个范围内 如果不在去另一个半继续二分数组查找 一直缩小范围最终得到结果
	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}
		// 左边有序 这里的等于是用于判断 如果 mid = left的情况的
		if nums[left] <= nums[mid] {
			// 在左边范围内 收缩右边界
			if nums[left] <= target && target < nums[mid] {
				right = mid - 1
			} else { // 否则在右边范围
				left = mid + 1
			}
		} else { // 右边有序
			// 在右边范围内 收缩左边界
			if nums[mid] < target && target <= nums[right] {
				left = mid + 1
			} else {
				// 否则在左边范围
				right = mid - 1
			}
		}
	}
	return -1

}

func searchNew(nums []int, target int) int {
	n := len(nums)

	left := 0
	right := n - 1

	for left <= right {
		mid := (left + right) >> 1
		if nums[mid] == target {
			return mid
		}
		// 左边有序
		if nums[left] <= nums[mid] {
			if nums[left] <= target && target < nums[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			if nums[mid] < target && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}
