package backpack

import "fmt"

// MultiplePack 朴素
func MultiplePack() {
	var (
		n, m    int
		v, w, s [1005]int
		f       [1005]int
	)

	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i], &s[i])
	}
	for i := 1; i <= n; i++ {
		for j := m; j >= v[i]; j-- {
			for k := 0; k <= s[i] && k*v[i] <= j; k++ {
				f[j] = max(f[j], f[j-k*v[i]]+k*w[i])
			}
		}
	}
	fmt.Println(f[m])

}

func multiplePack() {
	var (
		n, m    int
		v, w, s [1005]int
		f       [1005][1005]int
	)

	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&v[i], &w[i], &s[i])
	}
	for i := 1; i <= n; i++ {
		for j := 0; j <= m; j++ {
			for k := 0; k <= s[i] && k*v[i] <= j; k++ {
				f[i][j] = max(f[i][j], f[i-1][j-k*v[i]]+k*w[i])
			}
		}
	}
	fmt.Println(f[n][m])
}
