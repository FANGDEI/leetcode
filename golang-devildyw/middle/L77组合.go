package main

func main() {
	combine(5, 4)
}

func combine(n int, k int) [][]int {
	var res [][]int = make([][]int, 0)

	var backtrack func(index int, current []int)
	backtrack = func(index int, current []int) {
		if len(current) == k {
			temp := make([]int, len(current))
			copy(temp, current)
			res = append(res, temp)
			return
		}
		if index >= n+1 {
			return
		}

		for i := index; i <= n; i++ {
			backtrack(i+1, append(current, i))
		}
	}

	backtrack(1, make([]int, 0, k))
	return res
}
