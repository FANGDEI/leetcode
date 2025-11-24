package main

func main() {

}

func isValidSudoku(board [][]byte) bool {
	row := make([]map[byte]struct{}, 9)
	col := make([]map[byte]struct{}, 9)
	block := make([]map[byte]struct{}, 9)

	for i := 0; i < 9; i++ {
		row[i] = make(map[byte]struct{})
		col[i] = make(map[byte]struct{})
		block[i] = make(map[byte]struct{})
	}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] != '.' {
				num := board[i][j]
				// - i / 3：确定在第几行宫格（0/1/2）
				// - * 3：转换为宫格起始编号（0/3/6）
				// - j / 3：确定在第几列宫格（0/1/2）
				blockIndex := i/3*3 + j/3

				_, rowExist := row[i][num]
				_, colExist := col[j][num]
				_, blockExist := block[blockIndex][num]

				if rowExist || colExist || blockExist {
					return false
				} else {
					row[i][num] = struct{}{}
					col[j][num] = struct{}{}
					block[blockIndex][num] = struct{}{}
				}
			}
		}
	}

	return true
}
