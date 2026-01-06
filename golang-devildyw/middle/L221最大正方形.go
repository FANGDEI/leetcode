package main

func main() {

}

func maximalSquare(matrix [][]byte) int {

	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}
	maxLen := 0
	n := len(matrix)
	m := len(matrix[0])
	// dp[i][j] 标识以i,j为右下角的最长正方形边长
	dp := make([][]int, n+1)
	for i := range n + 1 {
		dp[i] = make([]int, m+1)
	}

	// 初始化
	for i := 0; i <= n; i++ {
		dp[i][0] = 0
	}

	for j := 0; j <= m; j++ {
		dp[0][j] = 0
	}

	// 状态转移方程
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if matrix[i-1][j-1] == '1' {
				// dp[i][j] = min(左边dp[i][j-1], 上面dp[i-1][j], 左上dp[i-1][j-1]) + 1
				// 首先得是一个正方形 其次要最大 那么只能是各个方向的最小值+1 才是这个i j 为右下角的到的最大正方形的边长
				dp[i][j] = min(min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1
				maxLen = max(maxLen, dp[i][j])
			}
		}
	}
	return maxLen * maxLen
}
