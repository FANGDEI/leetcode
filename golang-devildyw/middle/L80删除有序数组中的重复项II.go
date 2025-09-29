package main

import "fmt"

func main() {
	ints := []int{1, 1, 1, 2, 2, 3}
	duplicates := removeDuplicates(ints)
	for i := 0; i < duplicates; i++ {
		fmt.Print(ints[i])
		fmt.Print(" ")
	}

}

func removeDuplicates(nums []int) int {
	var (
		fast, slow, count int = 0, 0, 1
	)

	for ; fast < len(nums); fast++ {
		if fast > 0 && nums[fast] == nums[fast-1] {
			count++
		} else {
			count = 1
		}
		if count > 2 {
			continue
		}
		nums[slow] = nums[fast]
		slow++
	}
	return slow
}
