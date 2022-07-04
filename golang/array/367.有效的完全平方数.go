package array

func isPerfectSquare(num int) bool {
	l, r := 0, num
	for l <= r {
		m := (l + r) >> 1
		if m*m > num {
			r = m - 1
		} else if m*m < num {
			l = l + 1
		} else {
			return true
		}
	}
	return false
}
