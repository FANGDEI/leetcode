package main

func main() {}

func singleNumber(nums []int) int {
	ans := int32(0)
	for i := 0; i < 32; i++ {
		total := int32(0)
		// 对与第i位 如果都是出现了3次的元素的话 那么这个i位的和要么是0要么是3的倍数 如果包含了只出现一次的元素 并且该位有值 那么就不是3的倍数 取模就不等于1
		for _, num := range nums {
			total += int32(num) >> i & 1
		}

		if total%3 != 0 {
			ans |= 1 << i
		}
	}
	return int(ans)
}
