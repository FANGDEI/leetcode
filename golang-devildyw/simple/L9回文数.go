package main

import "math"

func main() {}

func isPalindromeNum(x int) bool {
	if x < 0 {
		return false
	}
	temp := x

	revertedNumber := 0
	for temp != 0 {
		pop := temp % 10
		// 如果越界 肯定不是回文数 因为原来的数没有越界
		//revertedNumber * 10 + pop > math.MaxInt32 反算的到下面不等式
		if revertedNumber > (math.MaxInt32-pop)/10 {
			return false
		}
		revertedNumber = revertedNumber*10 + pop
		temp /= 10
	}

	return revertedNumber == x
}
