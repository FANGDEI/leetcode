package maxheap

type heap struct {
	val []int
	len int
	cap int
}

func New(cap int) *heap {
	h := &heap{
		val: make([]int, 0, cap),
		len: 0,
		cap: cap,
	}
	// 哨兵
	h.val[0] = 0x7fffffff
	return h
}
