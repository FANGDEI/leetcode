package map_set

func intersection(nums1 []int, nums2 []int) []int {
	sli, set, res := []int{}, map[int]bool{}, map[int]bool{}

	for _, val := range nums1 {
		set[val] = true
	}

	for _, val := range nums2 {
		if set[val] && !res[val] {
			res[val] = true
			sli = append(sli, val)
		}
	}

	return sli
}
