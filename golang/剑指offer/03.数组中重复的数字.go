package golang

func findRepeatNumber(nums []int) int {
	a := [100005]int{}
	for i := 0; i < len(nums); i++ {
		if a[nums[i]] != 0 {
			return nums[i]
		}
		a[nums[i]]++
	}
	return 0
}
