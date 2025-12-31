package main

import "fmt"

func main() {

}

// 斜率
func maxPoints(points [][]int) int {
	n := len(points)
	if n <= 2 {
		return n
	}
	maxCount := 0
	// 利用数学斜率 确定一个起点
	for i := 0; i < len(points); i++ {
		cnt := make(map[string]int)
		localMax := 0
		for j := i + 1; j < n; j++ {
			dx := points[j][0] - points[i][0]
			dy := points[j][1] - points[i][1]

			g := gcd(dx, dy)
			k := fmt.Sprintf("%d/%d", dy/g, dx/g)
			cnt[k]++
			localMax = max(localMax, cnt[k])
		}
		// 算上起点
		maxCount = max(maxCount, localMax+1)
	}
	return maxCount
}

// 辗转相除法 太牛了哥
func gcd(a, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}
