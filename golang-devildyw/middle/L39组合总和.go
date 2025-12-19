package main

func main() {}

func combinationSum(candidates []int, target int) [][]int {
	result := make([][]int, 0)
	path := make([]int, 0, len(candidates)) // 预分配一点容量
	var backtrack func(index int, sum int)
	backtrack = func(index int, sum int) {
		if sum == target {
			temp := make([]int, len(path))
			copy(temp, path)
			result = append(result, temp)
			return
		}
		if sum > target {
			return
		}

		for i := index; i < len(candidates); i++ {
			path = append(path, candidates[i])
			backtrack(i, sum+candidates[i])
			path = path[:len(path)-1]
		}
	}
	backtrack(0, 0)
	return result
}
