package prefixsum

import "fmt"

func OneDimensionalPrefixSum(a [10005]int, n, l, r int) {
	var sum [10005]int
	for i := 1; i <= n; i++ {
		sum[i] = sum[i-1] + a[i]
	}
	fmt.Println(sum[r] - sum[l-1])
}
