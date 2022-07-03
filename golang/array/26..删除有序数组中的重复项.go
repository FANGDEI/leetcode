package array

func removeDuplicates(nums []int) int {
	i, j := 1, 0
	for i < len(nums) {
		if nums[i] != nums[j] {
			j++
			nums[j] = nums[i]
		}
		i++
	}
	j++
	return j
}
