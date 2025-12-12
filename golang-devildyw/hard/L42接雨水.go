package main

import "fmt"

func main() {

	fmt.Println(trap1([]int{4, 2, 0, 3, 2, 5}))

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

func trap1(height []int) int {
	// 我还是使用 总面积-柱子面积的方式做吧
	h := 0
	l, r := 0, len(height)-1
	total := 0

	for l <= r {
		for l <= r && height[l] <= h {
			l++
		}
		for l <= r && height[r] <= h {
			r--
		}

		if l <= r {
			newH := min(height[l], height[r])
			total += (newH - h) * (r - l + 1)
			h = newH
		}
	}
	zArea := 0
	// 计算柱子的面积
	for i := 0; i < len(height); i++ {
		zArea += height[i]
	}

	return total - zArea
}
