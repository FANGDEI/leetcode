package main

import (
	"fmt"
)

func main() {
	matrix := [][]int{
		{6, 9, 7},
	}
	//matrix := generateMatrix(3)
	order := spiralOrder(matrix)
	for i := range order {
		fmt.Print(order[i])
	}
}

// 模拟顺时针遍历 对于行的遍历或者列的遍历都会一行一列都遍历完成
func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}

	var (
		result      = make([]int, len(matrix)*len(matrix[0]))
		top, bottom = 0, len(matrix) - 1
		left, right = 0, len(matrix[0]) - 1
		index       = 0
	)

	for top <= bottom && left <= right {
		for col := left; col <= right; col++ {
			result[index] = matrix[top][col]
			index++
		}

		for row := top + 1; row <= bottom; row++ {
			result[index] = matrix[row][right]
			index++
		}

		// 当剩余区域退化成单行或单列时，前两步已经遍历完所有元素，如果继续执行后两步会重复遍历。
		if top < bottom && left < right {
			for col := right - 1; col >= left; col-- {
				result[index] = matrix[bottom][col]
				index++
			}

			for row := bottom - 1; row > top; row-- {
				result[index] = matrix[row][left]
				index++
			}
		}

		top++
		bottom--
		left++
		right--
	}

	return result
}
