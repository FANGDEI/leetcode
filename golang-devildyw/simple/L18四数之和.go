package main

import "sort"

func main() {

}

func fourSum(nums []int, target int) [][]int {
	result := make([][]int, 0)
	sort.Ints(nums)

	for i := 0; i < len(nums)-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < len(nums)-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			l, r := j+1, len(nums)-1
			for l < r {
				var sum int64 = int64(nums[l] + nums[r] + nums[i] + nums[j])
				if sum == int64(target) {
					result = append(result, []int{nums[i], nums[j], nums[l], nums[r]})
					for l < r && nums[l] == nums[l+1] {
						l++
					}
					for l < r && nums[r] == nums[r-1] {
						r--
					}
					l++
					r--
				} else if sum > int64(target) {
					r--
				} else {
					l++
				}
			}
		}
	}
	return result
}
