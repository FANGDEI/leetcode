package main

import (
	"fmt"
	"sort"
)

func main() {

}

// 排序做法
func longestConsecutiveBySort(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}
	// 先排序呗 我反正没啥好方法
	sort.Ints(nums)
	fmt.Println(nums)
	// 再找连续的
	result := 0
	last := 0
	count := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[last] {
			continue
		}
		if (nums[i] - 1) == nums[last] {
			count++
		} else {
			result = max(result, count)
			count = 1
		}
		last = i
	}
	result = max(result, count)
	return result
}

// hash 做法 但是耗时好像差不多
func longestConsecutive(nums []int) int {
	// 使用hash表 实现O(n)时间复杂度
	m := make(map[int]struct{})

	// 将nums数组中的数全部存放到set
	for _, v := range nums {
		m[v] = struct{}{}
	}

	result := 0

	// 遍历每个数字
	for num, _ := range m {
		// 如果出现num-1的数字 那么说明这个不是起点
		if _, exist := m[num-1]; exist {
			continue
		}
		//是起点开始不断寻找重点
		currentNum := num
		count := 1

		for {
			if _, exist := m[currentNum-1]; exist {
				count++
				currentNum = currentNum - 1
			} else {
				break
			}
		}
		// 更新result
		result = max(result, count)
	}
	return result
}
