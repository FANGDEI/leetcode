package main

func main() {
	maxArea([]int{1, 2, 4, 3})
}

// 每次移动较短的那条边，因为：
//   - 宽度会减小
//   - 只有移动较短边才有可能找到更高的边，从而增加面积
//   - 移动较长边只会让容器更小（因为高度由短边决定）
func maxArea(height []int) int {
	result := 0
	l, r := 0, len(height)-1

	for l < r {
		temp := min(height[l], height[r])
		result = max(result, temp*(r-l))
		// 移动较小的那一边（贪心策略）
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return result
}
