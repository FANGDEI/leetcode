package main

import "container/heap"

func main() {

}

type MedianFinder struct {
	minQ *MaxHeap // 大顶堆 存小的那一半数据 堆顶是最大的哪个数
	maxQ *numHeap // 小顶堆 存大的那一半数据 堆顶是最小的那个数
}

type numHeap []int

func (h numHeap) Len() int           { return len(h) }
func (h numHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h numHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

type MaxHeap struct {
	numHeap
}

// 包装numHeap 重写Less方法 实现大顶堆
func (h MaxHeap) Less(i, j int) bool { return h.numHeap[i] > h.numHeap[j] }

func (h *numHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *numHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Constructor() MedianFinder {
	return MedianFinder{
		minQ: &MaxHeap{
			numHeap{},
		},
		maxQ: &numHeap{},
	}
}

/*
*
minQ 中的元素 >= maxQ 保证 minQ 最多比 MaxQ多一个
Len(minQ) >= Len(maxQ)
*/
func (this *MedianFinder) AddNum(num int) {
	// 如果加入的元素 小于 minQ 的堆顶 那么他需要加入minQ 因为minQ的堆顶是minQ中最大的元素 比他小说明正好呆在minQ中
	if this.minQ.Len() == 0 || num <= this.minQ.numHeap[0] {
		heap.Push(this.minQ, num)
		if this.maxQ.Len()+1 < this.minQ.Len() {
			heap.Push(this.maxQ, heap.Pop(this.minQ))
		}
	} else { // 否则加入到maxQ 因为maxQ中存的是大的那一半数据 既然比minQ的堆顶还大了 那么先加入到maxQ 再平均
		heap.Push(this.maxQ, num)
		// 因为 maxQ 只能<= minQ 所以这里
		if this.maxQ.Len() > this.minQ.Len() {
			// maxQ 堆顶是最小的那个数 平衡时把这个数丢过去就对了
			heap.Push(this.minQ, heap.Pop(this.maxQ))
		}
	}
}

func (this *MedianFinder) FindMedian() float64 {
	// 说明此时是奇数 取minQ的堆顶即可 因为minQ在这时比maxQ多一个
	if this.minQ.Len() > this.maxQ.Len() {
		return float64(this.minQ.numHeap[0])
	}
	// 否则是偶数 这时取两个堆顶元素即可 因为是连着的可以这样理解 通过堆顶元素链接
	return float64(this.minQ.numHeap[0]+(*this.maxQ)[0]) / 2.0
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddNum(num);
 * param_2 := obj.FindMedian();
 */
