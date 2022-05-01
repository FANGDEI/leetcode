package golang

// 位运算
// a ^ b ^ c = a ^ c ^ b
// a ^ 0 = a  a ^ a = 0
// [a, a, b, b, c] => a ^ a ^ b ^ b ^ c = 0 ^ 0 ^ c => c
func singleNumber(nums []int) int {
	res := 0
	for _, val := range nums {
		res ^= val
	}
	return res
}
