package array

import (
	"leetcode/tools"
)

// 双指针
func maxArea(height []int) int {
	res := 0
	l, r := 0, len(height)-1
	for l < r {
		// 选择最短的高
		h := tools.Min(height[l], height[r])
		// 更新最大的容量
		res = tools.Max(res, h*(r-l))
		// 移动最短的高
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return res
}
