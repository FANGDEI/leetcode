package main

import "fmt"

func main() {
	result := strStr("hello", "ll")
	fmt.Printf("Result: %d\n", result)

	// 测试更多用例
	fmt.Printf("strStr(\"hello\", \"ll\"): %d\n", strStr("hello", "ll"))
	fmt.Printf("strStr(\"aaaaa\", \"bba\"): %d\n", strStr("aaaaa", "bba"))
	fmt.Printf("strStr(\"\", \"\"): %d\n", strStr("", ""))
	fmt.Printf("strStr(\"a\", \"\"): %d\n", strStr("a", ""))
}

func strStr(haystack string, needle string) int {
	for i := 0; i < len(haystack); i++ {
		if haystack[i] == needle[0] {
			j := 0
			for ; j < len(needle) && i+j < len(haystack); j++ {
				if haystack[i+j] != needle[j] {
					break
				}
			}
			if j == len(needle) {
				return i
			}
		}
	}
	return -1
}
