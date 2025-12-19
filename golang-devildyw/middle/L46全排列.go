package main

func main() {}

func permute(nums []int) [][]int {
	var res [][]int = make([][]int, 0)

	var backtrack func(nums, current []int)
	backtrack = func(nums, current []int) {
		if len(nums) == 0 {
			temp := make([]int, len(current))
			copy(temp, current)
			res = append(res, temp)
			return
		}

		for i := 0; i < len(nums); i++ {
			// 防止切片污染
			nextNums := make([]int, 0, len(nums)-1)
			nextNums = append(nextNums, nums[:i]...)
			nextNums = append(nextNums, nums[i+1:]...)

			backtrack(nextNums, append(current, nums[i]))
		}
	}
	backtrack(nums, []int{})
	return res
}
