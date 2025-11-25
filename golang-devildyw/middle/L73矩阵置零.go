package main

func main() {

}

func setZeroes(matrix [][]int) {
	//用一个hash表来记录行和列中有0的 以行和列为单位
	//遍历两次
	rowMap := make(map[int]struct{})
	colMap := make(map[int]struct{})

	n := len(matrix)
	m := len(matrix[0])

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if matrix[i][j] == 0 {
				if _, exist := rowMap[i]; !exist {
					rowMap[i] = struct{}{}
				}
				if _, exist := colMap[j]; !exist {
					colMap[j] = struct{}{}
				}
			}
		}
	}

	// 根据map的内容进行遍历 。
	for row := range rowMap {
		setZeroesRowHelper(matrix[row])
	}

	// 根据map的内容进行遍历
	for col := range colMap {
		setZeroesColHelper(matrix, col)
	}
}

func setZeroesRowHelper(row []int) {
	for i := 0; i < len(row); i++ {
		row[i] = 0
	}
}
func setZeroesColHelper(matrix [][]int, col int) {
	for i := 0; i < len(matrix); i++ {
		matrix[i][col] = 0
	}
}
