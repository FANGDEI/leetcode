package main

import (
	"fmt"
	"slices"
)

func main() {

}

func insert(intervals [][]int, newInterval []int) [][]int {
	insertIndex := 0
	for insertIndex < len(intervals) && intervals[insertIndex][0] < newInterval[0] {
		insertIndex++
	}

	// 2. 执行插入 (Go 1.21+ 使用 slices.Insert)
	// 如果 insertIndex 走到最后，slices.Insert 会自动追加到末尾，非常安全
	intervals = slices.Insert(intervals, insertIndex, newInterval)

	fmt.Println(intervals)

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
