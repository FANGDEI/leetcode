package main

func main() {
	twoSum([]int{3, 2, 4}, 6)
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, num := range nums {
		if value, exist := m[target-num]; exist {
			return []int{i, value}
		} else {
			m[num] = i
		}
	}

	return []int{}
}
