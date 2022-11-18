package string

import "strings"

// abaaba
func repeatedSubstringPattern(s string) bool {
	t := s + s
	t = t[1 : len(t)-1]
	println(t)
	return strings.Contains(t, s)
}
