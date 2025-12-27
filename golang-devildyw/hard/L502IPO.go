package main

import (
	"container/heap"
	"sort"
)

func main() {

}

type Project struct {
	Profits int
	Capital int
}

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] } // 大顶堆：谁大谁在上面
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	n := len(profits)
	projects := make([]Project, n)
	// 封装在一起 二维数组理论也行
	for i := range n {
		projects[i] = Project{Profits: profits[i], Capital: capital[i]}
	}

	//排序 按照启动资金升序排序
	sort.Slice(projects, func(i, j int) bool {
		return projects[i].Capital < projects[j].Capital
	})

	h := &IntHeap{}
	cur := 0
	heap.Init(h)
	// 循环k次
	for i := 0; i < k; i++ {
		// 每次都把启动资金小于w的的项目的利润存储大顶堆中
		for cur < n && projects[cur].Capital <= w {
			heap.Push(h, projects[cur].Profits)
			cur++
		}

		if h.Len() == 0 {
			break
		}
		// 获取大顶堆堆顶的项目（这次下来的最大利润）加到我们的启动资金上
		// 注意利润只增不减 也就是你即使需要花费启动资金 但是这不影响利润 不会因为买了一个项目 还会减去相应的利润
		// 所以这里如果在内层循环中没有获取到最新的项目 我们可以从堆里寻找第二个最大的项目（也就是下一次的堆顶）
		w += heap.Pop(h).(int)
	}

	return w
}
