package golang

// 一道水题 暴力即可通过
// map: key -> value, value -> index 遍历切片即可
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for index, val := range nums {
		if v, ok := m[target-val]; ok {
			return []int{index, v}
		}
		m[val] = index
	}
	return []int{}
}
