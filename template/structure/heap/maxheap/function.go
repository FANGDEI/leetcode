package maxheap

func (h *heap) insert(val int) {
	if h.len >= h.cap {
		newCap := h.cap * 2
		tmp := make([]int, 0, newCap)
		copy(tmp, h.val)
		h.val = tmp
	}
	h.val[h.len] = val
	h.len++
	i := h.len

	// 新插入的节点开始向上跳
	for i != 1 && val > h.val[i/2] {
		h.val[i] = h.val[i/2]
		i /= 2
	}
	h.val[i] = val
}

func (h *heap) Insert(values []int) {
	for _, val := range values {
		h.insert(val)
	}
}
