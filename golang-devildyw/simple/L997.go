package simple

import (
	"sort"
)

/*
*
 977. 有序数组的平方
*/
func SortedSquares(nums []int) []int {
	ans := make([]int, len(nums))
	for i, v := range nums {
		ans[i] = v * v
	}

	sort.Ints(ans)
	return ans
}
