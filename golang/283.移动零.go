package golang

func moveZeroes(nums []int) {
	i, j, size := 0, 0, len(nums)
	for i < size {
		if nums[i] != 0 {
			nums[j] = nums[i]
			j++
		}
		i++
	}
	for j < size {
		nums[j] = 0
		j++
	}
}
