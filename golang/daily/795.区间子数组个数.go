package daily

// 不懂哪里有问题捏
//func numSubarrayBoundedMax(nums []int, left int, right int) int {
//	ret := 0
//
//	for i := 0; i < len(nums); i++ {
//		if nums[i] < left || nums[i] > right {
//			continue
//		}
//		j, max := i, nums[i]
//		for j < len(nums) {
//			if nums[j] > max {
//				max = nums[j]
//			}
//			if max < left || max > right {
//				break
//			}
//			ret++
//			j++
//		}
//	}
//
//	return ret
//}

// 参考题解
func numSubarrayBoundedMax(nums []int, left int, right int) int {
	return calc(nums, right) - calc(nums, left-1)
}

func calc(nums []int, x int) int {
	ret := 0

	for i := 0; i < len(nums); i++ {
		if nums[i] > x {
			continue
		}
		j := i + 1
		for j < len(nums) && nums[j] <= x {
			j++
		}
		length := j - i
		ret += length * (length + 1) / 2
		i = j
	}

	return ret
}
