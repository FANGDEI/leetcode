package main

func main() {

}

func totalNQueens(n int) int {
	var res int

	cols := make(map[int]bool)
	// 对角线的下标存在规律
	// row + col 固定值 左下-右上
	diag1 := make(map[int]bool)
	// row - col 固定值 左上-右下
	diag2 := make(map[int]bool)

	var backtrack func(row int)
	backtrack = func(row int) {
		// 终止条件
		if row == n {
			res++
		}

		for col := 0; col < n; col++ {
			// 计算
			d1 := row + col
			d2 := row - col

			// 剪枝
			if cols[col] || diag1[d1] || diag2[d2] {
				continue
			}

			// 当前位置放置皇后
			// 不用借助二维数组 就认为在这里放置了2维数组即可
			cols[col] = true
			diag1[d1] = true
			diag2[d2] = true

			backtrack(row + 1)

			// 恢复现场
			cols[col] = false
			diag1[d1] = false
			diag2[d2] = false
		}
	}

	backtrack(0)
	return res
}
