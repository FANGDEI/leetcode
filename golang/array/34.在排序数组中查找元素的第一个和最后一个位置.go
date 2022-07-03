package array

func searchRange(nums []int, target int) []int {
	res := []int{-1, -1}
	if len(nums) == 0 {
		return res
	}
	l, r := 0, len(nums)-1
	for l < r {
		m := (l + r) >> 1
		if nums[m] < target {
			l = m + 1
		} else {
			r = m
		}
	}
	if nums[l] != target {
		return res
	}
	res[0] = l
	r = len(nums)
	for l < r {
		m := (l + r) >> 1
		if nums[m] > target {
			r = m
		} else {
			l = m + 1
		}
	}
	res[1] = l - 1
	return res
}
