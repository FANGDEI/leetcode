package dp

// f[i][j] 表示到达 (i, j) 的最大方案数
// 因为只能向下或者向右行动 => f[i][j] = f[i-1][j] + f[i][j-1]
func uniquePaths(m int, n int) int {
	var f [105][105]int
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 || j == 0 {
				f[i][j] = 1
			} else {
				f[i][j] = f[i-1][j] + f[i][j-1]
			}
		}
	}
	return f[m-1][n-1]
}
