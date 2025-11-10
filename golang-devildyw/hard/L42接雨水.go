package main

func main() {

	trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})

}

// 总面积-柱子面积 todo 后面用双指针做一下
func trap(height []int) int {
	// 将水也看做是柱子 先把总面积算出来 再减去柱子的面积
	// 通过双指针计算出每一层的面积 初始化高度是1 首先得有柱子才能装水不是？
	var (
		h          = 1               // 初始化层高
		left       = 0               // 初始化左指针
		right      = len(height) - 1 //初始化左指针
		totalArea  = 0
		pillarArea = 0
	)

	for left <= right {
		for left <= right && height[left] < h {
			left++
		}

		for left <= right && height[right] < h {
			right--
		}

		// 计算这一层的宽度
		totalArea += right - left + 1
		// 高度+1
		h++
	}

	// 装水的面积就是总面积减去柱子的面积
	for _, h := range height {
		pillarArea += h
	}

	return totalArea - pillarArea
}
