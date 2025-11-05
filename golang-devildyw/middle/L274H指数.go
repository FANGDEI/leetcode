package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(hIndex([]int{100}))
}

// hIndex 计算研究者的 H 指数。（自己想出来的）
// H 指数定义：有 h 篇论文的引用次数都至少为 h 次。
func hIndex(citations []int) int {
	maxH := 0

	// 先排序
	sort.Ints(citations)

	// 遍历
	n := len(citations)
	for i := 0; i < n; i++ {
		// 引用次数为0的不用管 因为我们h的初始化值就是0
		if citations[i] > 0 {
			// 当前论文及之后共有 (n - i) 篇
			// 如果当前论文的引用次数 ≥ (n - i)，
			// 说明至少有 (n - i) 篇论文的引用次数 ≥ (n - i)
			// 更新 H 指数
			if n-i <= citations[i] {
				maxH = max(maxH, n-i)
			}
		}
	}

	return maxH
}
