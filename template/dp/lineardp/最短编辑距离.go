package lineardp

import "fmt"

// f[i][j]
// f[i][j] 表示使 1 ~ a[i] 1 ~ b[j] 相等的最小操作次数
func shortestEditScript() {
	var (
		n, m int
		a, b string
		f    [1005][1005]int
	)

	fmt.Scan(&n, &a)
	fmt.Scan(&m, &b)

	a = " " + a
	b = " " + b

	// 初始化
	for i := 0; i <= n; i++ {
		f[0][i] = i
	}
	for i := 0; i <= m; i++ {
		f[i][0] = i
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			// f[i - 1][j] 删除一个字符使得 1 ~ a[i] 1 ~ b[j] 相等
			// f[i][j - 1] 添加一个字符使得 1 ~ a[i] 1 ~ b[j] 相等
			f[i][j] = min(f[i-1][j]+1, f[i][j-1]+1)
			// 修改一个字符使得  1 ~ a[i] 1 ~ b[j] 相等
			if a[i] == b[j] {
				f[i][j] = min(f[i][j], f[i-1][j-1])
			} else {
				f[i][j] = min(f[i][j], f[i-1][j-1]+1)
			}
		}
	}

	fmt.Println(f[n][m])
}
