package main

func main() {

}

func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	var (
		count int         = 0
		m     map[int]int = make(map[int]int)
	)

	for _, v1 := range nums1 {
		for _, v2 := range nums2 {
			m[v1+v2]++
		}
	}

	for _, v3 := range nums3 {
		for _, v4 := range nums4 {
			sum := -v3 - v4
			if countVal, ok := m[sum]; ok {
				count += countVal
			}
		}
	}
	return count
}
