package lineardp

import "fmt"

var (
	n, m int
	str  [1005]string
	f    [1005][1005]int
)

func ShortestEditScript(a, b string) int {
	a = " " + a
	b = " " + b

	la, lb := len(a)-1, len(b)-1

	for i := 0; i <= la; i++ {
		f[i][0] = i
	}
	for i := 0; i <= lb; i++ {
		f[0][i] = i
	}

	for i := 1; i <= la; i++ {
		for j := 1; j <= lb; j++ {
			f[i][j] = min(f[i-1][j], f[i][j-1]) + 1
			if a[i] == b[j] {
				f[i][j] = min(f[i][j], f[i-1][j-1])
			} else {
				f[i][j] = min(f[i][j], f[i-1][j-1]+1)
			}
		}
	}

	return f[la][lb]
}

func solveEditDistance() {
	fmt.Scan(&n, &m)
	for i := 1; i <= n; i++ {
		fmt.Scan(&str[i])
	}

	for i := 0; i < m; i++ {
		var s string
		var limit int
		fmt.Scan(&s, &limit)

		res := 0
		for i := 1; i <= n; i++ {
			if ShortestEditScript(str[i], s) <= limit {
				res++
			}
		}

		fmt.Println(res)
	}
}
