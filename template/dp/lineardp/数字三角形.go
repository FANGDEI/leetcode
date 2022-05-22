package lineardp

import "fmt"

func Digitaltriangle() {
	var (
		n int
		f [505][505]int
	)

	fmt.Scan(&n)
	for i := 1; i <= n; i++ {
		for j := 1; j <= i; j++ {
			fmt.Scan(&f[i][j])
		}
	}
	for i := n; i >= 1; i-- {
		for j := 1; j <= n; j++ {
			f[i][j] = max(f[i+1][j], f[i+1][j+1]) + f[i][j]
		}
	}
	fmt.Println(f[1][1])
}
