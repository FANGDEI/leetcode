package main

func main() {

}

func minDistance(word1 string, word2 string) int {
	n := len(word1)
	m := len(word2)

	// dp[i][j] 代表word1的前i个字符 变成word2的前j个字符所花的最小操作数
	dp := make([][]int, n+1)
	for i := range n + 1 {
		dp[i] = make([]int, m+1)
	}

	// 初始化 前0个字符 = 前0个字符 所以不用操作
	dp[0][0] = 0
	// word2 为空字符串 word1的前i个字符要得到 需要删除i个字符
	for i := 1; i <= n; i++ {
		dp[i][0] = i
	}

	// word1为空字符串 要得到word2的前j个字符需要插入
	for j := 1; j <= m; j++ {
		dp[0][j] = j
	}

	// 状态转移
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			// 如果此时word1的第i个字符 = word2的第j个字符 那么不需要操作 直接取 前一个操作的结果 word的前i-1个字符 变为 word2的第j-1个字符的最小操作数
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				// 可以有三个操作（删除、插入、替换） 需取最小 并且因为有操作了 所以需要+1
				dp[i][j] = min(
					dp[i-1][j], // 删除
					min(dp[i][j-1], // 新增
						dp[i-1][j-1])) + 1 // 替换
			}
		}
	}
	return dp[n][m]
}
