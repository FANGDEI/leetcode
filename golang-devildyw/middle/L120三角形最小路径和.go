package main

import "math"

func main() {

}

func minimumTotal(triangle [][]int) int {
	n := len(triangle)
	if n == 1 {
		return triangle[0][0]
	}

	//dp[i][j] 表示到第i层第j位置路径的最小值
	dp := make([][]int, n)
	//第0层就只有一个元素
	dp[0] = make([]int, 1)
	dp[0][0] = triangle[0][0]

	minDepth := math.MaxInt32

	for i := 1; i < n; i++ {
		m := len(triangle[i])
		dp[i] = make([]int, m)
		dp[i][0] = dp[i-1][0] + triangle[i][0]
		for j := 1; j < m; j++ {
			if j < m-1 {
				dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]
			} else {
				dp[i][j] = dp[i-1][j-1] + triangle[i][j]
			}
		}
	}

	for j := 0; j < len(triangle[n-1]); j++ {
		minDepth = min(minDepth, dp[n-1][j])
	}
	return minDepth
}
