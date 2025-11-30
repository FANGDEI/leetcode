package main

func main() {

}

// 栈不就是先进先出吗 虽然go没有现成的stack 但用slice也能实现
func isValid(s string) bool {
	// 栈
	stack := make([]byte, 0)
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			// append 函数本来就是往slice后添加元素的
			stack = append(stack, ')')
		} else if s[i] == '{' {
			stack = append(stack, '}')
		} else if s[i] == '[' {
			stack = append(stack, ']')
		} else {

			if len(stack) <= 0 || stack[len(stack)-1] != s[i] {
				return false
			}
			// 出栈
			stack = stack[:len(stack)-1]
		}

	}
	if len(stack) > 0 {
		return false
	}
	return true
}
