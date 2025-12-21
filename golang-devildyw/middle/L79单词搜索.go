package main

func main() {

}

// 笨方法
func exist(board [][]byte, word string) bool {
	// 感觉像是dfs
	// 遍历数组找到单词第一个字母 然后开始dfs吧

	n := len(board)
	m := len(board[0])

	var backtracking func(path []byte, index, i, j int) bool
	backtracking = func(path []byte, index, i, j int) bool {
		n := len(board)
		m := len(board[0])

		if i >= n || j >= m || i < 0 || j < 0 || board[i][j] == '#' || board[i][j] != word[index] {
			return false
		}

		if index == len(word)-1 {
			path = append(path, board[i][j])
			if string(path) == word {
				return true
			}
			return false
		}

		//标记 保存 用于标记当前下标对应字母已被使用防止重复使用 temp用于恢复
		temp := board[i][j]
		board[i][j] = '#'
		result := backtracking(append(path, temp), index+1, i+1, j) ||
			backtracking(append(path, temp), index+1, i-1, j) ||
			backtracking(append(path, temp), index+1, i, j+1) ||
			backtracking(append(path, temp), index+1, i, j-1)
		// 回溯
		board[i][j] = temp
		return result
	}
	first := word[0]
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if board[i][j] == first {
				if backtracking([]byte{}, 0, i, j) {
					return true
				}
			}
		}
	}
	return false
}

// 好方法就是在这个基础上优化的
func existNew(board [][]byte, word string) bool {
	// 感觉像是dfs
	// 遍历数组找到单词第一个字母 然后开始dfs吧

	n := len(board)
	m := len(board[0])

	var backtracking func(index, i, j int) bool
	backtracking = func(index, i, j int) bool {
		n := len(board)
		m := len(board[0])

		if i >= n || j >= m || i < 0 || j < 0 || board[i][j] == '#' || board[i][j] != word[index] {
			return false
		}

		if index == len(word)-1 {
			return true

		}

		//标记 保存 用于标记当前下标对应字母已被使用防止重复使用 temp用于恢复
		temp := board[i][j]
		board[i][j] = '#'
		result := backtracking(index+1, i+1, j) ||
			backtracking(index+1, i-1, j) ||
			backtracking(index+1, i, j+1) ||
			backtracking(index+1, i, j-1)
		// 回溯
		board[i][j] = temp
		return result
	}
	first := word[0]
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if board[i][j] == first {
				if backtracking(0, i, j) {
					return true
				}
			}
		}
	}
	return false
}
