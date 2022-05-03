package sort

func QuickSort(a []int, l, r int) {
	if l >= r {
		return
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
	QuickSort(a, l, j)
	QuickSort(a, j+1, r)
}
