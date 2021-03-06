package sort

func KthNumber(a []int, l, r, m int) int {
	if l >= r {
		return a[l]
	}
	k, i, j := a[(l+r)>>1], l-1, r+1
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
		return KthNumber(a, l, j, m)
	} else {
		return KthNumber(a, j+1, r, m-s)
	}
}
