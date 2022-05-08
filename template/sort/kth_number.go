package sort

func QuickSort(a []int, l, r, m int) int {
	if l >= r {
		return a[l]
	}
	k := a[(l+r)>>1]
	i, j := l-1, r+1
	for i < j {
		for {
			i++
			if a[i] >= k {
				break
			}
		}
		for {
			j--
			if a[j] <= k {
				break
			}
		}
		if i < j {
			a[i], a[j] = a[j], a[i]
		}
	}
	s := j - l + 1
	if m <= s {
		return QuickSort(a, l, j, m)
	} else {
		return QuickSort(a, j+1, r, m-s)
	}
}
