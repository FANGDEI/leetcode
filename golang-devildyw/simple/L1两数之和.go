package main

func main() {

}

func twoSum(nums []int, target int) []int {
	var (
		// 使用 map 记录找过的元素以及对应的下标
		targetMap map[int]int = make(map[int]int)
	)

	for i := 0; i < len(nums); i++ {
		if _, ok := targetMap[target-nums[i]]; ok {
			return []int{targetMap[target-nums[i]], i}
		}
		targetMap[nums[i]] = i
	}
	return []int{}
}
