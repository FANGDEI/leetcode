package main

func main() {
	println(reverseStr("abcdefg", 2))
}

func reverseStr(s string, k int) string {
	bytes := []byte(s)
	n := len(bytes)
	for i := 0; i < n; i += 2 * k {
		if i+k <= n {
			// 反转前k个
			reverseStrHelper(bytes, i, i+k-1)
		} else {
			// 最后不足k个字符了 反转到最后一个字符
			reverseStrHelper(bytes, i, n-1)
		}
	}
	return string(bytes)
}

func reverseStrHelper(bytes []byte, left int, right int) {
	for ; left < right; left, right = left+1, right-1 {
		bytes[left], bytes[right] = bytes[right], bytes[left]
	}
}
