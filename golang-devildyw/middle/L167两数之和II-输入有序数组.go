package main

func main() {

}

func twoSum(numbers []int, target int) []int {
	mapp := make(map[int]int)

	for i := 0; i < len(numbers); i++ {
		if index, ok := mapp[target-numbers[i]]; ok {
			return []int{index, i + 1}
		} else {
			mapp[numbers[i]] = i + 1
		}
	}
	return []int{}
}
