package array

func mySqrt(x int) int {
	l, r := 0, x
	for l <= r {
		m := (l + r) >> 1
		if m*m > x {
			r = m - 1
		} else if m*m < x {
			l = m + 1
		} else {
			return m
		}
	}
	return r
}
