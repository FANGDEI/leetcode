package map_set

import "sort"

func fourSum(nums []int, target int) [][]int {
	ret := [][]int{}

	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})

	n := len(nums)

	for i := 0; i < n-3 && nums[i]+nums[i+1]+nums[i+2]+nums[i+3] <= target; i++ {
		if i > 0 && nums[i] == nums[i-1] || nums[i]+nums[n-3]+nums[n-2]+nums[n-1] < target {
			continue
		}
		for j := i + 1; j < n-2 && nums[i]+nums[j]+nums[j+1]+nums[j+2] <= target; j++ {
			if j > i+1 && nums[j] == nums[j-1] || nums[i]+nums[j]+nums[n-2]+nums[n-1] < target {
				continue
			}
			for l, r := j+1, n-1; l < r; {
				if s := nums[i] + nums[j] + nums[l] + nums[r]; s == target {
					ret = append(ret, []int{nums[i], nums[j], nums[l], nums[r]})
					for l++; l < r && nums[l] == nums[l-1]; l++ {
					}
					for r--; l < r && nums[r] == nums[r+1]; r-- {
					}
				} else if s < target {
					l++
				} else {
					r--
				}
			}
		}
	}

	return ret
}
