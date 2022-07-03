package array

// 二分搜索
func search(nums []int, target int) int {
	l, r := 0, len(nums)-1
	for l <= r {
		m := (l + r) >> 1
		if nums[m] == target {
			return m
		} else if nums[m] > target {
			r = m - 1
		} else if nums[m] < target {
			l = m + 1
		}
	}
	return -1
}
