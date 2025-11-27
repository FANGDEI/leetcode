package main

func main() {

}

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int]int)

	for i, num := range nums {
		if value, exist := m[num]; exist && i-value <= k {
			return true
		}
		m[num] = i
	}
	return false
}
