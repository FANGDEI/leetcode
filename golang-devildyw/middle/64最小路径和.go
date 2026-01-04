package main

func main() {

}

func minPathSum(grid [][]int) int {
	// 跟上一道题差不多啊

	// dp[i][j] 表示到i j 位置的最小距离
	// dp[i][j] = min(dp[i-1][j], dp[i][j-1]) 对应题目中的只能向下或者向右移动
	n := len(grid)
	m := len(grid[0])
	dp := make([][]int, n)
	for i := range n {
		dp[i] = make([]int, m)
	}

	// 初始化
	dp[0][0] = grid[0][0]
	for i := 1; i < n; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}

	for j := 1; j < m; j++ {
		dp[0][j] = dp[0][j-1] + grid[0][j]
	}

	//状态转移
	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[n-1][m-1]

}
