package main

import "container/heap"

func main() {

}

type Pair struct {
	Sum  int
	idx1 int
	idx2 int
}

type PairHeap []Pair

func (h PairHeap) Len() int           { return len(h) }
func (h PairHeap) Less(i, j int) bool { return h[i].Sum < h[j].Sum }
func (h PairHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *PairHeap) Push(x interface{}) {
	*h = append(*h, x.(Pair))
}

func (h *PairHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	h := &PairHeap{}
	heap.Init(h)

	// 不能无脑吧所有的 nums1 和 nums2 的组合丢到堆里 这样会超时
	for i := 0; i < len(nums1); i++ {
		heap.Push(h, Pair{
			Sum:  nums1[i] + nums2[0],
			idx1: i,
			idx2: 0,
		})
	}

	result := make([][]int, 0, k)
	for k > 0 && h.Len() > 0 {
		top := heap.Pop(h).(Pair)
		i, j := top.idx1, top.idx2

		result = append(result, []int{nums1[i], nums2[j]})

		// 3. 将 nums2 的指针后移一位，推入新元素
		// 即：既然 (nums1[i], nums2[j]) 是最小的之一，
		// 那么它的“邻居” (nums1[i], nums2[j+1]) 才有资格成为下一个候选项
		if j+1 < len(nums2) {
			heap.Push(h, Pair{
				Sum:  nums1[i] + nums2[j+1],
				idx1: i,
				idx2: j + 1,
			})
		}
		k--
	}

	return result
}
