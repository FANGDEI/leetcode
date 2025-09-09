package main

func main() {
	println(reverseStr("abcdefg", 2))
}

func reverseStr(s string, k int) string {

	bytes := []byte(s)
	for start := 0; start < len(s); start += 2 * k {
		if start+k <= len(s) {
			reverseStrHelper(bytes, start, start+k-1)
		} else {
			reverseStrHelper(bytes, start, len(s)-1)
		}
	}

	return string(bytes)
}

func reverseStrHelper(bytes []byte, start, end int) {
	for start < end {
		bytes[start], bytes[end] = bytes[end], bytes[start]
		start++
		end--
	}
}
