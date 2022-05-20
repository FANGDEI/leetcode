package backpack

import "fmt"

var n, m int
var v, w [1005]int
var f [1005][1005]int

func solve01Backpack() {
	fmt.Scanf("%d %d", &n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scanf("%d %d", &v[i], &w[i])
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			f[i][j] = f[i-1][j]
			if j >= v[i] {
				f[i][j] = max(f[i][j], f[i-1][j-v[i]]+w[i])
			}
		}
	}
	fmt.Println(f[n][m])
}

// 优化
//func main() {
//	fmt.Scanf("%d %d", &n, &m)
//	for i := 1; i <= n; i++ {
//		fmt.Scanf("%d %d", &v[i], &w[i])
//	}
//	for i := 1; i <= n; i++ {
//		for j := m; j >= v[i]; j-- {
//			f[j] = max(f[j], f[j - v[i]] + w[i])
//		}
//	}
//	fmt.Println(f[m])
//}
