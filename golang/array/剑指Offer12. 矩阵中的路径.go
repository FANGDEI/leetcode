package array

var (
	dx = []int{-1, 1, 0, 0}
	dy = []int{0, 0, -1, 1}
)

func exist(board [][]byte, word string) bool {
	m := make([][]int, 8)
	for i := 0; i < 8; i++ {
		m[i] = make([]int, 8)
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			m[i][j] = 1
			res := wordFind(m, board, i, j, 0, word)
			if res {
				return true
			}
			m[i][j] = 0
		}
	}

	return false
}

func wordFind(m [][]int, board [][]byte, i, j, now int, word string) bool {
	if board[i][j] != word[now] {
		return false
	}
	if now == len(word)-1 {
		return true
	}

	for k := 0; k < 4; k++ {
		nx, ny := i+dx[k], j+dy[k]
		if nx < 0 || nx >= len(board) || ny < 0 || ny >= len(board[0]) || m[nx][ny] == 1 {
			continue
		}
		m[nx][ny] = 1
		res := wordFind(m, board, nx, ny, now+1, word)
		if res {
			return res
		}
		m[nx][ny] = 0
	}

	return false
}
