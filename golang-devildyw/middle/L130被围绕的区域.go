package main

func main() {}

func solve(board [][]byte) {
	//既然在的'O'不算被包围的 那么我们从边缘起手找到那些'O'并且找出与那些'O' 相连的'O'并把他们标记为'F'
	if board == nil || len(board) == 0 {
		return
	}

	m := len(board)
	n := len(board[0])

	for i := 0; i < m; i++ {
		// 边缘按行遍历 边缘即位行的两边
		dfs1(board, i, 0)
		dfs1(board, i, n-1)
	}

	for j := 0; j < n; j++ {
		//按列遍历，边缘即位列的两边
		dfs1(board, 0, j)
		dfs1(board, m-1, j)
	}
	// 遍历数组 把剩下'O'转为'X'（走过一遍后没被包围的'O'）都变成'F'了 需要把F还原
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'F' {
				board[i][j] = 'O'
			} else {
				board[i][j] = 'X'
			}
		}
	}

}

func dfs1(board [][]byte, i, j int) {
	m := len(board)
	n := len(board[0])
	if i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O' {
		return
	}
	//如果是'O' 感染为'F'
	board[i][j] = 'F'
	//上下左右四个方向找寻相连的'O'
	dfs1(board, i-1, j)
	dfs1(board, i+1, j)
	dfs1(board, i, j-1)
	dfs(board, i, j+1)
}
