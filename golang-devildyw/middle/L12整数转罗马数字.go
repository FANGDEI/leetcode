package main

func main() {

}

func intToRoman(num int) string {
	// 方法1: 贪心算法 - 使用切片保持顺序
	// 关键：把所有符号（包括特殊的减法形式）从大到小排列
	var (
		values  = []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
		symbols = []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
		result  = ""
	)

	for i := 0; i < len(values); i++ {
		count := num / values[i] // 看看可以用当前罗马数字几次
		if count > 0 {
			num -= count * values[i]
			for count > 0 {
				result += symbols[i]
				count--
			}
		}
		if num == 0 {
			return result
		}
	}
	return result
}
