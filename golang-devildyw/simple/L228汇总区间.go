package main

import "fmt"

func main() {

}

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}
	if len(nums) == 1 {
		return []string{fmt.Sprintf("%d", nums[0])}
	}

	result := make([]string, 0)
	// 模拟 跟刚才的题差不多
	start := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] <= nums[i-1]+1 {
			continue
		} else {
			if nums[start] == nums[i-1] {
				result = append(result, fmt.Sprintf("%d", nums[start]))
			} else {
				result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[i-1]))
			}
			start = i
		}
	}
	if nums[start] == nums[len(nums)-1] {
		result = append(result, fmt.Sprintf("%d", nums[start]))
	} else {
		result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[len(nums)-1]))
	}
	return result
}
