package lineardp

import "fmt"

func LIS() {
	var (
		n, res int
		a, f   [1005]int
	)

	fmt.Scan(&n)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
	}
	for i := 1; i <= n; i++ {
		f[i] = 1
		for j := 1; j <= n; j++ {
			if a[i] > a[j] {
				f[i] = max(f[i], f[j]+1)
			}
		}
		res = max(res, f[i])
	}
	fmt.Println(res)
}
