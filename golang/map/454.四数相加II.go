package map_set

func fourSumCount(nums1 []int, nums2 []int, nums3 []int, nums4 []int) int {
	abmap, ret := map[int]int{}, 0

	for _, v1 := range nums1 {
		for _, v2 := range nums2 {
			abmap[v1+v2]++
		}
	}

	for _, v3 := range nums3 {
		for _, v4 := range nums4 {
			if abmap[-v3-v4] != 0 {
				ret += abmap[-v3-v4]
			}
		}
	}

	return ret
}
