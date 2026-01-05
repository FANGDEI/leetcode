package main

func main() {

}
func longestPalindrome(s string) string {

	//dp[i][j] 表示 从i位置到j位置是否是回文串
	// dp[i][j] = (s[i] == s[j]) && dp[i+1][i-1]
	n := len(s)
	// 长度小于2 那么最长回文子串就是他自己
	if n < 2 {
		return s
	}

	dp := make([][]bool, n)
	for i := range n {
		dp[i] = make([]bool, n)
	}
	// 初始化
	dp[n-1][n-1] = true

	maxLen := 1
	begin := 0
	for i := n - 2; i >= 0; i-- {
		for j := i; j < n; j++ {
			// 如果i==j 就一个字符肯定是回文串 如果 j-i+1 = 2 那就是2个字符 但是s[i] = s[j] 那肯定也是回文串
			if s[i] == s[j] {
				if j-i+1 < 3 {
					dp[i][j] = true
				} else {
					dp[i][j] = dp[i+1][j-1]
				}
			}

			if dp[i][j] && maxLen < (j-i+1) {
				maxLen = j - i + 1
				begin = i
			}
		}
	}
	return s[begin : begin+maxLen]

}
