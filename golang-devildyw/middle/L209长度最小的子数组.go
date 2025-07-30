package main

func MinSubArrayLen(target int, nums []int) int {
	//滑动窗口
	l := 0
	r := len(nums)
	var result = r + 1
	var sum = 0
	for j := 0; j < r; j++ {
		sum += nums[j]
		for sum >= target {
			result = min(result, j-l+1)
			sum -= nums[l]
			l++
		}
	}

	if result == r+1 {
		return 0
	}
	return result

}
