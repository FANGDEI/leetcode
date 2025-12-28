package main

func main() {

}

func singleNumber(nums []int) int {
	result := 0
	// ^ 按位异或 0 与 a 异或 得到 a
	// a ^ a = 0 相同元素异或的0
	// 且 a ^ b ^ c = a ^ c ^ b 满足交换律 这就意味着我们可以全部异或起来 再按照交换律相同的元素的得0 最终得到就是我们要的只出现一次的元素
	for _, v := range nums {
		result ^= v
	}

	return result
}
