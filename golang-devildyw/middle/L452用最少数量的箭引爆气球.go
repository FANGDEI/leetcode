package main

import (
	"sort"
)

func main() {
	findMinArrowShots([][]int{{10, 16}, {2, 8}, {1, 6}, {7, 12}})
}

// 贪心吧 按右边界排序可以避免大包小的情况
func findMinArrowShots(points [][]int) int {
	if len(points) == 0 {
		return 0
	}

	// 先按照右边界排序，为了尽可能的射穿更多气球，这之间一定要射在边缘
	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})

	result := 1

	//第一支箭射在第一个气球的边缘
	arrowPos := points[0][1]
	for i := 1; i < len(points); i++ {
		// 如果当前气球的左边界>箭的位置
		// 说明了这支箭射不到它，需要新加一支箭
		if points[i][0] > arrowPos {
			result++
			// 新箭射在这个新气球的右边缘
			arrowPos = points[i][1]
		}
		//如果points[i][0] <= arrowPos 说明左边缘小于这只箭的范围 能够被射到这个忽略
	}

	return result
}
