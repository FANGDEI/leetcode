package main

import "fmt"

var (
	n, m    int
	v, w, s [1005]int
	f       [1005][1005]int
)

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i], &s[i])
	}
	for i := 1; i <= n; i++ {
		for j := 0; j <= n; j++ {
			for k := 0; k <= s[i] && k*v[i] <= j; k++ {
				f[i][j] = max(f[i][j], f[i-1][j-k*v[i]]+k*w[i])
			}
		}
	}
	fmt.Println(f[n][m])
}
