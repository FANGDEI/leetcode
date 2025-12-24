package main

import "fmt"

func main() {
	searchMatrix([][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3)
}

func searchMatrix(matrix [][]int, target int) bool {
	// 先根据二分从按行查询 看看能不能找到这个元素 如果不能找到 那就从小于该元素的上一行开始查找
	rows := len(matrix)
	cols := len(matrix[0])

	left := 0
	right := rows - 1

	for left <= right {
		mid := (right-left)/2 + left
		if matrix[mid][0] >= target {
			right = mid
		} else if matrix[mid][0] < target {
			left = mid + 1
		}
	}
	fmt.Println(left)
	// 如果走到这一步 说明没有通过第一次二分找到 需要在left的那一行开始找
	targetRow := left
	left = 0
	right = cols - 1

	for left <= right {
		mid := (right-left)/2 + left
		if matrix[targetRow][mid] > target {
			right = mid - 1
		} else if matrix[targetRow][mid] < target {
			left = mid + 1
		} else {
			return true
		}
	}

	return false
}
