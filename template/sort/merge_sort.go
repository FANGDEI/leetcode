package sort

var (
	a   = make([]int, 100005)
	tmp = make([]int, 100005)
)

func MergeSort(s, e int) {
	if s < e {
		m := (s + e) >> 1
		MergeSort(s, m)
		MergeSort(m+1, e)
		merge(s, m, e)
	}
}

func merge(s, m, e int) {
	pb, p1, p2 := 0, s, m+1
	for p1 <= m && p2 <= e {
		if a[p1] < a[p2] {
			tmp[pb] = a[p1]
			pb++
			p1++
		} else {
			tmp[pb] = a[p2]
			pb++
			p2++
		}
	}
	for p1 <= m {
		tmp[pb] = a[p1]
		pb++
		p1++
	}
	for p2 <= e {
		tmp[pb] = a[p2]
		pb++
		p2++
	}
	for i := 0; i < e-s+1; i++ {
		a[s+i] = tmp[i]
	}
}
