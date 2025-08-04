package main

import "fmt"

func main() {
	n := 4
	matrix := generateMatrix(n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			fmt.Print(matrix[i][j])
		}
		fmt.Println()
	}
}

/*
模拟顺时针画矩阵的过程:
填充上行从左到右
填充右列从上到下
填充下行从右到左
填充左列从下到上

offset 执行

如果n是奇数 中心元素单独设置 一般是  n/2 n/2的位置
*/
func generateMatrix(n int) [][]int {
	// 初始化二维数组
	var matrix [][]int
	matrix = make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, n)
	}

	loop := n / 2
	var incr int = 1
	var center = n / 2
	startX, startY := 0, 0
	offset := 1
	for loop > 0 {
		i, j := startX, startY

		// 列变行不变
		for ; j < n-offset; j++ {
			matrix[i][j] = incr
			incr++
		}

		// 行变列不变
		for ; i < n-offset; i++ {
			matrix[i][j] = incr
			incr++
		}

		// 列变行不变
		for ; j > startX; j-- {
			matrix[i][j] = incr
			incr++
		}

		// 行变列不变
		for ; i > startY; i-- {
			matrix[i][j] = incr
			incr++
		}

		offset++
		startX++
		startY++
		loop--
	}

	if n%2 == 1 {
		matrix[center][center] = n * n
	}
	return matrix
}
