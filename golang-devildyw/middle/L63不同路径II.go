package main

func main() {

}

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	// 参考爬楼梯的思路
	// dp[i][j] 表示到达 i 、j位置的不同路径数量
	// i,j 为障碍物 那么该位置的不同路径数为0
	// 状态转移方程：dp[i][j] = dp[i][j-1] + dp[i-1][j] 因为只能向下或向右移动 所以不同路径数等于这两个位置的到的路径数的和
	n := len(obstacleGrid)
	m := len(obstacleGrid[0])

	dp := make([][]int, n)

	for i := range n {
		dp[i] = make([]int, m)
	}

	// 初始化
	if obstacleGrid[0][0] >= 1 {
		dp[0][0] = 0
	} else {
		dp[0][0] = 1
	}

	// 初始化0 0 位置的不同路径为1
	for i := 1; i < n; i++ {
		if obstacleGrid[i][0] >= 1 {
			dp[i][0] = 0
			continue
		}
		dp[i][0] = dp[i-1][0]
	}

	for j := 1; j < m; j++ {
		if obstacleGrid[0][j] >= 1 {
			dp[0][j] = 0
			continue
		}
		dp[0][j] = dp[0][j-1]
	}

	// 状态转移开始
	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			if obstacleGrid[i][j] >= 1 {
				dp[i][j] = 0
				continue
			}
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[n-1][m-1]

}
