package array

func searchInsert(nums []int, target int) int {
	l, r, m := 0, len(nums)-1, 0
	for l <= r {
		m = (l + r) >> 1
		if nums[m] == target {
			return m
		} else if nums[m] > target {
			r = m - 1
		} else if nums[m] < target {
			l = m + 1
		}
	}
	return r + 1
}
