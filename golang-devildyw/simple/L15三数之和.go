package main

import (
	"fmt"
	"sort"
)

func main() {

	for _, ints := range threeSum([]int{-1, 0, 1, 2, -1, -4}) {
		for _, num := range ints {
			fmt.Println(num)
		}
	}
}

func threeSum(nums []int) [][]int {
	var res [][]int

	sort.Ints(nums)
	numsLen := len(nums)

	for i := 0; i < numsLen-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		l, r := i+1, numsLen-1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[l], nums[r]})
				// 跳过重复的 l
				for l < r && nums[l] == nums[l+1] {
					l++
				}
				// 跳过重复的 r
				for l < r && nums[r] == nums[r-1] {
					r--
				}
				// 两个指针都得移动 如果不移动可能会得到相同的值
				l++
				r--
			} else if sum < 0 {
				l++
			} else {
				r--
			}
		}
	}

	return res
}
