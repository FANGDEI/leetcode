package maxheap

import "testing"

func TestNew(t *testing.T) {
	h := New(10)
	h.Insert([]int{1, 3, 2, 5, 7})
	t.Log(h.val)
}

func TestHeap_Insert(t *testing.T) {
	h := New(5)
	h.Insert([]int{1, 3, 2, 5, 7})
	h.insert(6)
	t.Log(h.val)
}

func TestHeap_Remove(t *testing.T) {
	h := New(5)
	h.Insert([]int{1, 3, 2, 5, 7})
	t.Log(h.Remove())
	t.Log(h)
}

func TestHeap_Sort(t *testing.T) {
	h := New(5)
	h.Insert([]int{1, 3, 2, 5, 7})
	n := h.len
	for i := 1; i <= n; i++ {
		val, _ := h.Remove()
		t.Log(val, " ")
	}
}
