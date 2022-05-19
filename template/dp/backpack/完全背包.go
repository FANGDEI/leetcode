package backpack

import "fmt"

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
