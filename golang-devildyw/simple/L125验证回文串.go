package main

func main() {

}

func isPalindrome(s string) bool {
	var filterArr = make([]byte, 0)

	for i := 0; i < len(s); i++ {
		if s[i] >= 'A' && s[i] <= 'Z' {
			filterArr = append(filterArr, s[i]+32)
		}
		if s[i] >= 'a' && s[i] <= 'z' || s[i] >= '0' && s[i] <= '9' {
			filterArr = append(filterArr, s[i])
		}
	}
	s1 := string(filterArr)
	return s1 == reverseStringHelper(filterArr)
}

func reverseStringHelper(bytes []byte) string {

	for i, j := 0, len(bytes)-1; i < j; i, j = i+1, j-1 {
		bytes[i], bytes[j] = bytes[j], bytes[i]
	}
	return string(bytes)
}
