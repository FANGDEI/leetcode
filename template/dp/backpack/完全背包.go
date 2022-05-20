package backpack

import "fmt"

// CompletePack 朴素
func CompletePack() {
	var (
		n, m int
		v, w [1005]int
		f    [1005][1005]int
	)

	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i])
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			f[i][j] = f[i-1][j]
			if j >= v[i] {
				f[i][j] = max(f[i][j], f[i][j-v[i]]+w[i])
			}
		}
	}
	fmt.Println(f[n][m])

}

// 空间优化后
func completePack() {
	var (
		n, m    int
		v, w, f [1005]int
	)

	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i])
	}
	for i := 1; i <= n; i++ {
		for j := v[i]; j <= m; j++ {
			f[j] = max(f[j], f[j-v[i]]+w[i])
		}
	}
	fmt.Println(f[m])
}
