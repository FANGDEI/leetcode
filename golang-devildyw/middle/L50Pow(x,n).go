package main

func main() {

}

// 快速幂
func myPow(x float64, n int) float64 {
	if n < 0 {
		x = 1 / x
		n = -n
	}
	// 快速幂
	res := 1.0
	currentProduct := x
	// 2^5 = 2 * 2^4 = 2 * 4^2 = 2 * 16 = 32 以此类推
	// 2^8 = 4^4 = 16^2 = 256
	// 迭代快速幂
	for n > 0 {
		// 如果 N 的奇数需要拆开 变成 偶数在处理，说明这项需要乘入结果
		if n%2 == 1 {
			res = res * currentProduct
		}
		// 底数翻倍
		currentProduct = currentProduct * currentProduct
		n /= 2
	}
	return res
}
