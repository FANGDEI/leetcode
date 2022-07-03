package array

import (
	"leetcode/tools"
)

// 滑动窗口
func minSubArrayLen(target int, nums []int) int {
	i, res, sum := 0, 0x7f7f7f7f, 0
	for j := 0; j < len(nums); j++ {
		// sum <= target 右指针右移动 sum 加上当前数
		sum += nums[j]
		// sum >= target 左指针右移动 更新区间的最小值
		for sum >= target {
			res = tools.Min(res, j-i+1)
			sum -= nums[i]
			i++
		}
	}
	// res >= 0x7f7f7f7f 表明 sum <= target 返回 0
	if res >= 0x7f7f7f7f {
		return 0
	}
	return res
}
