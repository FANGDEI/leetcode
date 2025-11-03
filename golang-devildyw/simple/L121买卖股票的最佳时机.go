package main

import "math"

func main() {
	maxProfit([]int{7, 1, 5, 3, 6, 4})
}

func maxProfit(prices []int) int {
	// 从左往右遍历，更新过程中的买入最小值 并不断更新利润 初始化买入最小值是第一天
	var (
		minPrice = math.MaxInt32
		result   = 0
	)

	for i := 0; i < len(prices); i++ {
		if minPrice > prices[i] {
			minPrice = prices[i]
		} else {
			profit := prices[i] - minPrice
			if profit > result {
				result = profit
			}
		}
	}
	return result
}
