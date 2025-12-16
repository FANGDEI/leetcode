package main

func main() {}

func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	nr := len(grid)
	nc := len(grid[0])
	num_islands := 0
	for i := 0; i < nr; i++ {
		for j := 0; j < nc; j++ {
			if grid[i][j] == '1' {
				num_islands++
				dfs(grid, i, j)
			}
		}
	}

	return num_islands
}

func dfs(grid [][]byte, i, j int) {
	nr := len(grid)
	nc := len(grid[0])
	// 边界 四边是水 并且也是保证dfs不超过边界
	if i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0' {
		return
	}
	//标记当前节点已被查找过
	grid[i][j] = '0'
	// 往上查找
	dfs(grid, i-1, j)
	// 往下查找
	dfs(grid, i+1, j)
	// 往左
	dfs(grid, i, j-1)
	//往右
	dfs(grid, i, j+1)
}
