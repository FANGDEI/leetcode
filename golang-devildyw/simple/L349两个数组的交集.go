package main

// 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
func main() {

}

func intersection(nums1 []int, nums2 []int) []int {
	var (
		intMap map[int]int = make(map[int]int)
		result []int       = make([]int, 0)
	)

	for i := 0; i < len(nums1); i++ {
		intMap[nums1[i]] = i
	}

	for i := 0; i < len(nums2); i++ {
		if _, ok := intMap[nums2[i]]; ok {
			result = append(result, nums2[i])
			delete(intMap, nums2[i])
		}
	}
	return result
}
