package main

func main() {

}

func rotate(nums []int, k int) {
	//k可能大于nums的长度
	k %= len(nums)
	// 先反转整个数组
	reverseNums(nums)
	// 其次反转前k个
	reverseNums(nums[:k])
	// 最后反转后面的
	reverseNums(nums[k:])
}

func reverseNums(nums []int) {
	for i, j := 0, len(nums)-1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
