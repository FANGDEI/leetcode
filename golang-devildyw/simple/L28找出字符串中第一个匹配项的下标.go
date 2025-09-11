package main

import "fmt"

func main() {
	result := strStr("aaa", "aaaa")
	fmt.Printf("Result: %d\n", result)

	// 测试更多用例
	fmt.Printf("strStr(\"hello\", \"ll\"): %d\n", strStr("hello", "ll"))
	fmt.Printf("strStr(\"aaaaa\", \"bba\"): %d\n", strStr("aaaaa", "bba"))
	fmt.Printf("strStr(\"\", \"\"): %d\n", strStr("", ""))
	fmt.Printf("strStr(\"a\", \"\"): %d\n", strStr("a", ""))
}

func strStr(haystack string, needle string) int {
	n, m := len(haystack), len(needle)
	// 索引走到 n - m 即可 因为过了这个范围 haystack 残余的字符没法完全匹配needle
	for i := 0; i+m <= n; i++ {
		if haystack[i] == needle[0] {
			j := 0
			for ; j < m; j++ {
				if haystack[i+j] != needle[j] {
					break
				}
			}
			if j == m {
				return i
			}
		}
	}
	return -1
}
