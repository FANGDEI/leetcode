package main

func main() {
	isPalindrome("0P")
}

func isPalindrome(s string) bool {
	// 快慢指针先把非字母数字给去掉
	bytes := []byte(s)
	slow := 0
	for fast := 0; fast < len(bytes); fast++ {
		if s[fast] >= 'A' && s[fast] <= 'Z' {
			bytes[slow] = s[fast] + 'a' - 'A'
			slow++
		} else if s[fast] >= 'a' && s[fast] <= 'z' {
			bytes[slow] = s[fast]
			slow++
		} else if s[fast] >= '0' && s[fast] <= '9' {
			bytes[slow] = s[fast]
			slow++
		}
	}

	bytes = bytes[0:slow]

	i, j := 0, len(bytes)-1
	for i < j {
		if bytes[i] != bytes[j] {
			return false
		}
		i++
		j--
	}
	return true
}
