package daily

import (
	"sort"
)

func checkArithmeticSubarrays(nums []int, l []int, r []int) []bool {
	var res []bool
	for i := 0; i < len(l); i++ {
		var tmp []int
		left, right := l[i], r[i]
		for j := left; j < right+1; j++ {
			tmp = append(tmp, nums[j])
		}
		sort.Slice(tmp, func(i, j int) bool {
			return tmp[i] < tmp[j]
		})
		check := true
		for j := 0; j < len(tmp)-1; j++ {
			if tmp[j+1]-tmp[j] != tmp[1]-tmp[0] {
				check = false
			}
		}
		res = append(res, check)
	}
	return res
}
