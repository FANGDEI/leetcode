package main

func main() {
	productExceptSelf([]int{1, 2, 3, 4})
}

// 我的思路 计算出数组的前缀乘机 和 后缀乘积
func productExceptSelf(nums []int) []int {
	var (
		n               int   = len(nums)
		frontAccumulate []int = make([]int, n)
		backAccumulate  []int = make([]int, n)
		result          []int = make([]int, n)
	)

	// 前缀乘积 frontAccumulate[i] = nums[0] * nums[1] ....   * nums[i-1]
	frontAccumulate[0] = 1
	for i := 1; i < n; i++ {
		//frontAccumulate[i] 为不包含当前节点的前缀乘积
		frontAccumulate[i] = frontAccumulate[i-1] * nums[i-1]
	}

	// 后缀乘积 backAccumulate[i] = nums[i+1] * nums[i+2] ... * nums[n-1]
	backAccumulate[n-1] = 1
	for i := n - 2; i >= 0; i-- {
		//backAccumulat[i] 为不包含当前节点的后缀乘积
		backAccumulate[i] = backAccumulate[i+1] * nums[i+1]
	}

	// 计算
	for i := 0; i < n; i++ {
		result[i] = frontAccumulate[i] * backAccumulate[i]
	}

	return result
}
