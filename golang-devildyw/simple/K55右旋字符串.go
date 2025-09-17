package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	function()
}

// 反转字符串的指定区间
func reverse(str []byte, start, end int) {
	for start < end {
		str[start], str[end] = str[end], str[start]
		start++
		end--
	}
}

func function() {
	reader := bufio.NewReader(os.Stdin)
	var k int
	_, _ = fmt.Scanf("%d", &k)
	str, _, _ := reader.ReadLine()
	n := len(str)

	// 处理k大于n的情况
	k = k % n

	// 如果k为0，不需要旋转
	if k == 0 {
		fmt.Println(string(str))
		return
	}

	// 三次反转实现右旋，空间复杂度O(1)
	// 1. 反转整个字符串
	reverse(str, 0, n-1)
	// 2. 反转前k个字符
	reverse(str, 0, k-1)
	// 3. 反转后n-k个字符
	reverse(str, k, n-1)

	fmt.Println(string(str))

	// 原来的O(n)空间复杂度方法（已注释）
	// s := string(str[n-k:n]) + string(str[:n-k])
	// fmt.Println(string(s))
}
