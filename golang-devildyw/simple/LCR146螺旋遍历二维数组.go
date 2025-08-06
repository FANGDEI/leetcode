package main

import "fmt"

func main() {
	var array [][]int = [][]int{
		{1, 2, 3},
		{8, 9, 4},
		{7, 6, 5},
	}

	order := spiralArray(array)
	for i := range order {
		fmt.Print(order[i], ",")
	}

}

func spiralArray(array [][]int) []int {
	if len(array) == 0 || len(array[0]) == 0 {
		return []int{}
	}

	var (
		rows, columns            int = len(array), len(array[0])
		order                        = make([]int, rows*columns)
		index                        = 0
		left, right, top, bottom int = 0, columns - 1, 0, rows - 1
	)

	for left <= right && top <= bottom {
		for column := left; column <= right; column++ {
			order[index] = array[top][column]
			index++
		}

		for row := top + 1; row <= bottom; row++ {
			order[index] = array[row][right]
			index++
		}

		if left < right && top < bottom {
			for column := right - 1; column >= left; column-- {
				order[index] = array[bottom][column]
				index++
			}

			for row := bottom - 1; row > top; row-- {
				order[index] = array[row][left]
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
