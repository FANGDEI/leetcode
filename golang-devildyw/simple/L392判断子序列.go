package main

func main() {
	isSubsequence("abc", "ahbgdc")
}

// 快慢指针
func isSubsequence(s string, t string) bool {
	slow := 0
	fast := 0
	for slow < len(s) && fast < len(t) {
		if s[slow] == t[fast] {
			slow++
		}
		fast++
	}

	if slow != len(s) {
		return false
	}
	return true
}
