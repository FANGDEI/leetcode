package main

func main() {
	println(reverseStr("abcdefg", 2))
}

func reverseStr(s string, k int) string {
	bytes := []byte(s)
	len := len(bytes)

	for i := 0; i < len; i += 2 * k {
		if i+k <= len {
			reverseStrHelper(bytes[i : i+k])
		} else {
			reverseStrHelper(bytes[i:len])
		}
	}
	return string(bytes)
}

// 反转切片内的字符 切片是引用类型 修改的是结构体里面相同的数组指针
func reverseStrHelper(bytes []byte) {
	for i, j := 0, len(bytes)-1; i < j; i, j = i+1, j-1 {
		bytes[i], bytes[j] = bytes[j], bytes[i]
	}
}
