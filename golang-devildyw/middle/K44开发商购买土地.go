package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

/*
在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。

现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。

然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。

注意：区块不可再分。

第一行输入两个正整数，代表 n 和 m。

接下来的 n 行，每行输出 m 个正整数。

请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
*/
func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	var n, m int
	_, _ = fmt.Sscanf(scanner.Text(), "%d %d", &n, &m)

	var nums = make([][]int, n)
	for i := 0; i < len(nums); i++ {
		scanner.Scan()
		split := strings.Split(scanner.Text(), " ")
		row := make([]int, m)
		for j := 0; j < m; j++ {
			row[j], _ = strconv.Atoi(split[j])
		}
		nums[i] = row
	}

	// 初始化矩阵前缀和
	var preMatrix = make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		preMatrix[i] = make([]int, m+1)
	}

	//preMatrix[i][j] 表示 第i行j列位置的矩阵前缀和 相当于一个正方形的右下角 保存的是整个正方形的所有和累加
	for i := 1; i < n+1; i++ {
		for j := 1; j < m+1; j++ {
			//  会重复算一次preMatrix[i-1][j-1] 所以需要减去 preMatrix[i][j-1] 和 preMatrix[i-1][j] 都包含了 preMatrix[i-1][j-1]
			preMatrix[i][j] = nums[i-1][j-1] + preMatrix[i-1][j] + preMatrix[i][j-1] - preMatrix[i-1][j-1]
		}
	}

	totalSum := preMatrix[n][m]
	minDiff := math.MaxInt32

	// 只有两种分割方式
	// 按行分割
	for i := 0; i < n; i++ {
		topSum := preMatrix[i+1][m]

		bottomSum := totalSum - topSum

		diff := int(math.Abs(float64(bottomSum - topSum)))
		if diff < minDiff {
			minDiff = diff
		}
	}

	// 按列分割
	for i := 0; i < m; i++ {
		leftSum := preMatrix[n][i+1]
		rightSum := totalSum - leftSum
		diff := int(math.Abs(float64(rightSum - leftSum)))
		if diff < minDiff {
			minDiff = diff
		}
	}

	fmt.Println(minDiff)

}
