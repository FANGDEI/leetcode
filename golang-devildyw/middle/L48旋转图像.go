package main

func main() {
	rotate([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
}

func rotate(matrix [][]int) {
	// 感觉这是一道极其吃数学思维的题 能想出先转置在水平翻转
	n := len(matrix)

	// 先转置
	for i := 0; i < n; i++ {
		for j := 0; j <= i; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}
	// 再水平翻转 逐行水平翻转
	for i := 0; i < n; i++ {
		swap(matrix[i])
	}
}

func swap(row []int) {
	i, j := 0, len(row)-1
	for i < j {
		row[i], row[j] = row[j], row[i]
		i++
		j--
	}
}
