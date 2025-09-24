package main

func main() {

}

func merge(nums1 []int, m int, nums2 []int, n int) {

	sorted := make([]int, m+n)
	i, j, k := 0, 0, 0

	for i < m && j < n {
		if nums1[i] < nums2[j] {
			sorted[k] = nums1[i]
			k++
			i++
		} else {
			sorted[k] = nums2[j]
			k++
			j++
		}
	}

	for i < m {
		sorted[k] = nums1[i]
		k++
		i++
	}

	for j < n {
		sorted[k] = nums2[j]
		k++
		j++
	}

	for k = 0; k < m+n; k++ {
		nums1[k] = sorted[k]
	}

}
