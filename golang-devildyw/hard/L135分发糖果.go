package main

import "fmt"

func main() {
	// 测试用例
	testCases := []struct {
		ratings  []int
		expected int
	}{
		{[]int{1, 0, 2}, 5},
		{[]int{1, 2, 2}, 4},
		{[]int{1, 3, 2, 2, 1}, 7},
		{[]int{1, 2, 87, 87, 87, 2, 1}, 13},
	}

	for i, tc := range testCases {
		result := candy(tc.ratings)
		status := "✓"
		if result != tc.expected {
			status = "✗"
		}
		fmt.Printf("测试 %d %s: ratings=%v, 期望=%d, 实际=%d\n",
			i+1, status, tc.ratings, tc.expected, result)
	}

	// 演示详细过程
	fmt.Println("\n详细演示 [1,0,2]:")
}

func candy(ratings []int) int {

	// 这就是一个上坡递增和下坡递减的过程 但是我们只知道最低是多少 但是没办法轻易知道最高是多少
	// 最好的办法就是从两边分别遍历 从做到由找上坡的递增 而不用关心右边的下坡
	// 从右往往左找上坡的底层 这一部分就是上面的右边的下坡 最后找到两边遍历结果的最大值就是当前小朋友的获得糖果 这样就能在满足要求的前提下获得糖果的最小值

	var (
		n            = len(ratings)
		result int   = 0
		left   []int = make([]int, n)
		right  []int = make([]int, n)
	)

	// 从左往右遍历 遇到更大的+1 小的就1
	for i := 0; i < n; i++ {
		if i > 0 && ratings[i] > ratings[i-1] {
			left[i] = left[i-1] + 1
		} else {
			left[i] = 1
		}
	}

	for i := n - 1; i >= 0; i-- {
		if i < n-1 && ratings[i] > ratings[i+1] {
			right[i] = right[i+1] + 1
		} else {
			right[i] = 1
		}
	}

	// 找到两遍的最大值
	for i := 0; i < n; i++ {
		result += max(left[i], right[i])
	}

	return result
}
