package main

func main() {
	println(isHappy(19))
}

func isHappy(n int) bool {
	// 通过set记录中间过程数 防止出现循环
	m := make(map[int]struct{})

	for n != 1 {
		temp := 0
		for n != 0 {
			mod := n % 10
			temp += mod * mod
			n /= 10
		}
		if _, exist := m[temp]; exist {
			return false
		}
		n = temp
		m[temp] = struct{}{}
	}

	return true
}
