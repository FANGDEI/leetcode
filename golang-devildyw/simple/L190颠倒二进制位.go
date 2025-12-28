package main

func main() {

}

func reverseBits(n int) int {
	var result int
	for i := 0; i < 32 && n > 0; i++ {
		// n 的最后一位 与 1取并 并左移到高位 也就相当于反转嘛 再与result按位或
		result |= n & 1 << (31 - i)
		// n 向右移动 相当于舍去最后一位 上一位成为最新的最后一位
		n >>= 1
	}
	return result
}
