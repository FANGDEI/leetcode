package main

func main() {

}

func isInterleave(s1 string, s2 string, s3 string) bool {
	n := len(s1)
	m := len(s2)

	if (m + n) != len(s3) {
		return false
	}
	// dp[i][j] 表示 s3 字符串 i + j 这个位置上 能否被s1 和 s2 分别截止下标i 和 j的字符串表示
	// 二位数组 列代表 s1的字符串 行代表 s2 的字符串
	dp := make([][]bool, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]bool, m+1)
	}

	dp[0][0] = true

	for i := 1; i <= n; i++ {
		dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1]
	}

	for j := 1; j <= m; j++ {
		dp[0][j] = dp[0][j-1] && s2[j-1] == s3[j-1]
	}

	// 状态转移方程
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			k := i + j - 1
			// 相当于 dp[i][j] 的字符要么从上面来（s1的字符） 要么从左边来（s2的字符）
			dp[i][j] = (dp[i-1][j] && s3[k] == s1[i-1]) || (dp[i][j-1] && s3[k] == s2[j-1])
		}
	}

	return dp[n][m]

}
