package lineardp

import "fmt"

func LCS() {
	var (
		n, m int
		a, b string
		f    [1005][1005]int
	)

	fmt.Scan(&n, &m)
	fmt.Scanln(&a)
	fmt.Scanln(&b)
	a = "a" + a
	b = "b" + b

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if a[i] == b[j] {
				f[i][j] = f[i-1][j-1] + 1
			} else {
				f[i][j] = max(f[i-1][j], f[i][j-1])
			}
		}
	}

	fmt.Println(f[n][m])
}
