package map_set

import "sort"

func threeSum(nums []int) [][]int {
	ret := [][]int{}

	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})

	for i := 0; i < len(nums)-1; i++ {
		// 正确去重
		// {-1, -1, 2}
		// 若使用 if i > 0 && nums[i] == nums[i + 1] 则会漏掉
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		l, r := i+1, len(nums)-1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			if sum > 0 {
				r--
			} else if sum < 0 {
				l++
			} else {
				ret = append(ret, []int{nums[i], nums[l], nums[r]})
				for l < r && nums[r] == nums[r-1] {
					r--
				}
				l++
				r--
			}
		}
	}

	return ret
}
