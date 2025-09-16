package main

func main() {

}

func removeElement(nums []int, val int) int {
	var (
		fast, slow int = 0, 0
	)

	for ; fast < len(nums); fast++ {
		if nums[fast] != val {
			nums[slow] = nums[fast]
			slow++
		}
	}

	return slow
}
