package tools

func Min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func Reverse(ss string) string {
	s := []byte(ss)
	for l, r := 0, len(s)-1; l < r; l++ {
		s[l], s[r] = s[r], s[l]
		r--
	}
	return string(s)
}
