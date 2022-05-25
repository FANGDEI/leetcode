package sort

import "testing"

func TestHeapSort(t *testing.T) {
	a := []int{1, 9, 2, 4, 5, 7, 8}
	a = HeapSort(a)
	t.Log(a)
}
