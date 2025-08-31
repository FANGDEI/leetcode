package main

func main() {
	println(isHappy(7))
}

func isHappy(n int) bool {
	// 使用一个map来记录 如果没到1之前出现循环 那么这个数就不可能快乐数
	var (
		set map[int]struct{} = make(map[int]struct{})
	)
	for n != 1 {
		// 对n进行拆分
		sum := 0
		for n != 0 {
			i := n % 10
			sum += i * i
			n = n / 10
		}

		// 如果 n 已经在 set里面存在了 那么代表循环了 永远不可能等于1
		if _, ok := set[sum]; ok {
			return false
		}
		// 不存在先存到 set 里面
		set[sum] = struct{}{}
		// 更新n的值
		n = sum
	}
	// 跳出循环 代表这n已经等于1了
	return true
}
