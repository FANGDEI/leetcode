package main

func main() {

	repeatedSubstringPattern("aba")

}

func repeatedSubstringPattern(s string) bool {
	if s == "" {
		return false
	}

	newS := s + s
	newS = newS[1 : len(newS)-1]
	n := len(newS)
	m := len(s)
	// 转为暴力匹配字符出现的第一个下标了
	for i := 0; i+m <= n; i++ {
		if newS[i] == s[0] {

			j := 0
			for ; j < m; j++ {
				if newS[j+i] != s[j] {
					break
				}
			}

			if j == m {
				return true
			}
		}
	}
	return false
}
