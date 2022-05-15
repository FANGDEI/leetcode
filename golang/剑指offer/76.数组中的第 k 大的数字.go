package golang

// 水题
func findKthLargest(nums []int, k int) int {
	return quickSort(nums, 0, len(nums)-1, k)
}

func quickSort(a []int, l, r, m int) int {
	if l == r {
		return a[l]
	}
	k, i, j := a[(l+r)>>1], l-1, r+1
	for i < j {
		for {
			i++
			if a[i] <= k {
				break
			}
		}
		for {
			j--
			if a[j] >= k {
				break
			}
		}
		if i < j {
			a[i], a[j] = a[j], a[i]
		}
	}
	s := j - l + 1
	if m <= s {
		return quickSort(a, l, j, m)
	} else {
		return quickSort(a, j+1, r, m-s)
	}
}
