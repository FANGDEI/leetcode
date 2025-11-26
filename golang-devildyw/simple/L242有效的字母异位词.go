package main

func main() {

}

func isAnagram(s string, t string) bool {
	// 早期退出优化
	if len(s) != len(t) {
		return false
	}
	hash := make([]int, 26)

	for i := 0; i < len(s); i++ {
		hash[s[i]-'a']++
		hash[t[i]-'a']--
	}

	for i := 0; i < 26; i++ {
		if hash[i] != 0 {
			return false
		}
	}
	return true
}
