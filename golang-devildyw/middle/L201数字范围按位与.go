package main

func main() {}

func rangeBitwiseAnd(left int, right int) int {
	shift := 0
	// 核心思路：寻找 left 和 right 的二进制“公共前缀”。
	// 1. 只要 left != right，说明这段区间内发生过进位。
	// 2. 根据数学规律，进位必然导致低位经历过 0，因此按位与的结果低位全为 0。
	// 3. 我们不断同时“右移”去掉不一致的低位，直到两者相等找到公共前缀。
	for left < right {
		left >>= 1
		right >>= 1
		shift++
	}
	return left << shift
}
