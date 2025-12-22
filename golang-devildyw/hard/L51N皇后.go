package main

import "strings"

func main() {}

func solveNQueens(n int) [][]string {
	var res [][]string
	board := make([][]string, n)
	// 初始化数组
	for i := range n {
		board[i] = make([]string, n)
		for j := range n {
			board[i][j] = "."
		}
	}

	// 记录攻击范围的集合
	// 因为我们是一行一行放入皇后的 所以我们只用考虑 同一列、对角线上是否存在皇后就行
	// 左下-右上对角线的 row + col 是一个固定值
	// 右下-左上对角线的 row - col 是一个固定值 所以可以使用这个规律来判断对角线上是否存在皇后
	cols := make(map[int]bool)
	diag1 := make(map[int]bool)
	diag2 := make(map[int]bool)

	var backtrack func(row int)
	backtrack = func(row int) {
		//1. 结束条件 当我们走到了第n+1行 因为row是从0开始的
		if row == n {
			// 复制副本
			temp := make([]string, n)
			for i := 0; i < n; i++ {
				temp[i] = strings.Join(board[i], "")
			}
			res = append(res, temp)
			return
		}

		// 2. 尝试遍历当前的每一行
		for col := 0; col < n; col++ {
			// 计算对角线上的值
			d1 := row + col
			d2 := row - col

			// 剪枝
			if cols[col] || diag1[d1] || diag2[d2] {
				continue
			}

			// 4.证明当前位置可以存放皇后
			board[row][col] = "Q"
			cols[col] = true
			diag1[d1] = true
			diag2[d2] = true

			// 继续寻找下一行
			backtrack(row + 1)

			// 恢复现场
			board[row][col] = "."
			cols[col] = false
			diag1[d1] = false
			diag2[d2] = false
		}
	}

	backtrack(0)

	return res
}
