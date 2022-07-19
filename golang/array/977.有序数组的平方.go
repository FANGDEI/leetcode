package array

func sortedSquares(nums []int) []int {
	i, j, k := 0, len(nums)-1, len(nums)-1
	res := make([]int, len(nums))
	for i <= j {
		if nums[i]*nums[i] > nums[j]*nums[j] {
			res[k] = nums[i] * nums[i]
			k--
			i++
		} else {
			res[k] = nums[j] * nums[j]
			k--
			j--
		}
	}
	return res
}
