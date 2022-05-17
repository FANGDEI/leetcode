package maxheap

// The structure of the Heap
type heap struct {
	val []int
	len int
	cap int
}

// New Get a Heap with the capacity
func New(cap int) *heap {
	h := &heap{
		val: make([]int, cap+1, cap+1),
		len: 0,
		cap: cap,
	}
	// 哨兵
	h.val[0] = 0x7fffffff
	return h
}
