package main

func main() {

}

func mySqrt(x int) int {
	left := 0
	right := x
	result := 0
	for left <= right {
		mid := left + (right-left)/2
		if mid*mid <= x {
			result = mid
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return result
}
