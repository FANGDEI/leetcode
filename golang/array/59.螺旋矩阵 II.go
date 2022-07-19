package array

func generateMatrix(n int) [][]int {
	dx := []int{0, 1, 0, -1}
	dy := []int{1, 0, -1, 0}
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}

	x, y, t := 0, 0, 0
	for i := 1; i <= n*n; i++ {
		res[x][y] = i
		if row, col := x+dx[t], y+dy[t]; row < 0 || row >= n || col < 0 || col >= n || res[row][col] > 0 {
			t = (t + 1) % 4
		}
		x += dx[t]
		y += dy[t]
	}
	return res
}
