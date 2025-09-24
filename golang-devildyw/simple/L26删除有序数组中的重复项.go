package main

func main() {

}

func removeDuplicates(nums []int) int {
	var (
		fast, slow = 0, 0
	)

	for ; fast < len(nums); fast++ {
		if fast > 0 && nums[fast] == nums[fast-1] {
			continue
		}
		nums[slow] = nums[fast]
		slow++
	}
	return slow
}
