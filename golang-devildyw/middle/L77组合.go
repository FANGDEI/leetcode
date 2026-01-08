package main

func main() {
	combine(5, 4)
}

func combine(n int, k int) [][]int {
	result := make([][]int, 0)
	path := make([]int, 0)

	var dfs func(index int)
	dfs = func(index int) {
		if len(path) == k {
			temp := make([]int, len(path))
			copy(temp, path)
			result = append(result, temp)
		}

		for i := index; i <= n; i++ {
			path = append(path, i)
			dfs(i + 1)
			path = path[:len(path)-1]
		}
	}
	dfs(1)
	return result
}
