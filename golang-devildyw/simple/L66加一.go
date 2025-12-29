package main

func main() {}

func plusOne(digits []int) []int {
	c := 1
	idex := len(digits) - 1
	for idex >= 0 {
		num := digits[idex]
		sum := c + num
		digits[idex] = sum % 10
		c = sum / 10
		idex--
	}

	if c > 0 {
		return append([]int{c}, digits...)
	}
	return digits
}
