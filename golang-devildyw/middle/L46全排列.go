package main

func main() {}

func permute(nums []int) [][]int {
	result := make([][]int, 0)
	path := make([]int, 0)
	n := len(nums)

	set := make(map[int]bool)
	var dfs func()
	dfs = func() {
		if len(path) == n {
			tempResult := make([]int, len(path))
			copy(tempResult, path)
			result = append(result, tempResult)
			return
		}

		for i := 0; i < len(nums); i++ {
			if set[nums[i]] {
				continue
			}
			set[nums[i]] = true
			path = append(path, nums[i])
			dfs()
			path = path[:len(path)-1]
			set[nums[i]] = false
		}
	}

	dfs()
	return result
}
