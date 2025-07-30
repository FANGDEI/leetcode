package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

/*
给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。

第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。

学习下 ACM模式
*/
func main() {
	scanner := bufio.NewScanner(os.Stdin)

	//读取第一行，转化为整数n
	scanner.Scan()
	n, _ := strconv.Atoi(scanner.Text())

	// 接下来读取n个数
	nums := make([]int, n+1)
	for i := 0; i < n; i++ {
		scanner.Scan()
		nums[i], _ = strconv.Atoi(scanner.Text())
		if i != 0 {
			nums[i] += nums[i-1]
		}
	}

	// 读取接下来的区间值

	for scanner.Scan() {
		var l, r int
		_, err := fmt.Sscanf(scanner.Text(), "%d %d", &l, &r)
		if err != nil {
			break
		}

		if l > 0 {
			// 如果不用原始数组存前缀和的话 可以这样 sum[r] - sum[l] + nums[l] 因为这里的区间和 用前缀和去做的话 不能 sum[r] - sum[l] 这样会把nums[l] 给减掉
			fmt.Println(nums[r] - nums[l-1])
		} else {
			fmt.Println(nums[r])
		}
	}

}
