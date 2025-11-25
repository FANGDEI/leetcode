package main

func main() {

}

func gameOfLife(board [][]int) {
	// src 是 [][]byte
	dst := make([][]int, len(board))

	for i := range board {
		dst[i] = make([]int, len(board[i]))
		copy(dst[i], board[i])
	}
	n, m := len(board), len(board[0])

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			// 找到八个方向的细胞数 如果是边界只需要看周围存在的就行
			count := 0
			if j > 0 && dst[i][j-1] == 1 { // 上
				count++
			}
			if j < m-1 && dst[i][j+1] == 1 { // 下
				count++
			}
			if i > 0 && dst[i-1][j] == 1 { // 左
				count++
			}
			if i < n-1 && dst[i+1][j] == 1 { // 右
				count++
			}
			if i > 0 && j > 0 && dst[i-1][j-1] == 1 { //左上
				count++
			}
			if i > 0 && j < m-1 && dst[i-1][j+1] == 1 { //左下
				count++
			}
			if i < n-1 && j > 0 && dst[i+1][j-1] == 1 { //右上
				count++
			}
			if i < n-1 && j < m-1 && dst[i+1][j+1] == 1 { //右下
				count++
			}

			if count < 2 {
				board[i][j] = 0
			} else if count == 3 {
				board[i][j] = 1
			} else if count > 3 {
				board[i][j] = 0
			}
		}
	}
}
