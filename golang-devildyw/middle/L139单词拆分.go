package main

func main() {

}

func wordBreak(s string, wordDict []string) bool {
	wordSet := make(map[string]bool)
	for _, w := range wordDict {
		wordSet[w] = true
	}

	// dp[i] 表示 [0,i]这段字符串能否被worddict拆分
	dp := make([]bool, len(s)+1)
	// 0 表示空串 默认能拆分
	dp[0] = true

	// i 从 1开始 因为切片到i-1的位置 所以这里从1开始 当然也能从0开始 只不过后面需要处理
	for i := 1; i <= len(s); i++ {
		// j 表示切割点
		for j := 0; j < i; j++ {
			// 0 到 i 之间 有一个j可以分割字符串 且j之前的字符串能被分割 j 到 i 之间的字符串也能被表示 依此类推
			if dp[j] && wordSet[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}
	return dp[len(s)]
}
