package string

func reverseStr(s string, k int) string {
	for i := 0; i < len(s); i += 2 * k {
		if i+k <= len(s) {
			s = reverse(s, i, i+k-1)
		} else {
			s = reverse(s, i, len(s))
		}
	}

	return s
}

func reverse(s string, left, right int) string {
	tmp := []byte(s)
	for l, r := left, right; l < r; l++ {
		tmp[l], tmp[r] = tmp[r], tmp[l]
		r--
	}
	return string(tmp)
}
