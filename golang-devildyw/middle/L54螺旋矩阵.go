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
		rows, columns            = len(matrix), len(matrix[0])
		order                    = make([]int, rows*columns)
		index                    = 0
		left, right, top, bottom = 0, columns - 1, 0, rows - 1
	)
	for left <= right && top <= bottom {
		for column := left; column <= right; column++ {
			order[index] = matrix[top][column]
			index++
		}

		for row := top + 1; row <= bottom; row++ {
			order[index] = matrix[row][right]
			index++
		}

		// 遍历 左下角的限制条件 边界条件 只有一行或者一列的时候重复遍历
		if left < right && top < bottom {
			for column := right - 1; column >= left; column-- {
				order[index] = matrix[bottom][column]
				index++
			}

			for row := bottom - 1; row > top; row-- {
				order[index] = matrix[row][left]
				index++
			}
		}

		left++
		right--
		top++
		bottom--
	}

	return order
}
