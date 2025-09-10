package main

import "sort"

func main() {

}

func threeSum(nums []int) [][]int {
	var (
		result [][]int
	)

	sort.Ints(nums)
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		m := make(map[int]int)
		for j := i + 1; j < len(nums); j++ {
			if _, ok := m[nums[j]]; ok {
				continue
			}

			if k, ok := m[-nums[i]-nums[j]]; ok {
				result = append(result, []int{nums[i], nums[j], nums[k]})
			}
			m[nums[j]] = j
		}
	}
	return result
}
