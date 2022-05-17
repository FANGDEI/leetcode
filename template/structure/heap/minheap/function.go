package maxheap

import "errors"

// insert Insert value into the Heap
func (h *heap) insert(val int) {
	if h.len >= h.cap {
		newCap := h.cap * 2
		tmp := make([]int, newCap+1, newCap+1)
		copy(tmp, h.val)
		h.val = tmp
		h.cap = newCap
	}
	h.len++

	i := h.len
	// 新插入的节点开始上跳
	for i != 1 && val < h.val[i/2] {
		h.val[i] = h.val[i/2]
		i /= 2
	}
	h.val[i] = val
}

// Insert Insert values into the Heap
func (h *heap) Insert(values []int) {
	for _, val := range values {
		h.insert(val)
	}
}

// Remove Get the largest value of the Heap
func (h *heap) Remove() (int, error) {
	if h.len == 0 {
		return 0, errors.New("heap is empty")
	}

	res, last := h.val[1], h.val[h.len]
	h.len--

	parent, min := 1, 2
	for min <= h.len {
		if min < h.len && h.val[min+1] < h.val[min] {
			min += 1
		}
		// 判断 last 是否能够放在此节点
		if last < h.val[min] {
			break
		}
		// 将 last 下移
		h.val[parent] = h.val[min]
		parent = min
		min = parent * 2
	}
	h.val[parent] = last
	return res, nil
}
