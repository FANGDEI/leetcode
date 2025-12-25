package main

func main() {}

func findMin(nums []int) int {
	// 找最小值
	left := 0
	right := len(nums) - 1

	// 当没有确切的值的时候 使用left < right 退出是 left 和 right 都指向同一个结果
	for left < right {
		mid := (left + right) >> 1
		// 为什么只跟 nums[right]比 因为如果是旋转的数组或者没选转的数组那么第一次的mid 一定是小于right的 不跟left 比是因为选转后看你mid 就在最小值的位置大于left是很常见了，不能成为我们收缩数组的条件 这样会误判 可能导致我们错吧最小值区间漏掉
		if nums[mid] < nums[right] {
			// 为什么是right = mid 因为 mid 可能就是最小值
			right = mid
		} else {
			left = mid + 1
		}
	}
	return nums[left]
}
