package main

import "sort"

func main() {

}

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return [][]int{}
	}
	// 这题我会啊 先排序
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	result := make([][]int, 0, len(intervals))
	start := 0
	for i := 1; i < len(intervals); i++ {
		if intervals[i-1][1] >= intervals[i][0] {
			intervals[i][1] = max(intervals[i-1][1], intervals[i][1])
			continue
		} else {
			// 区间截止到当前位置-1
			result = append(result, []int{intervals[start][0], intervals[i-1][1]})
			start = i
		}
	}

	result = append(result, []int{intervals[start][0], intervals[len(intervals)-1][1]})

	return result
}
