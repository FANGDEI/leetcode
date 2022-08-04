package map_set

func isHappy(n int) bool {
	for i := 0; i < 100; i++ {
		n = next(n)
		if n == 1 {
			return true
		}
	}
	return false
}

func next(n int) int {
	nxt := 0
	for n != 0 {
		nxt += int((n % 10) * (n % 10))
		n /= 10
	}
	return nxt
}
