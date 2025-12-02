package main

import "strconv"

func main() {

}

func evalRPN(tokens []string) int {
	stack := make([]string, 0)

	symbol := map[string]bool{
		"+": true,
		"-": true,
		"*": true,
		"/": true,
	}
	for _, token := range tokens {
		if exist := symbol[token]; exist {
			// 弹出栈顶两个元素
			b := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			a := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			ai, _ := strconv.Atoi(a)
			bi, _ := strconv.Atoi(b)
			var res string
			if token == "+" {
				res = strconv.Itoa(ai + bi)
			} else if token == "-" {
				res = strconv.Itoa(ai - bi)
			} else if token == "*" {
				res = strconv.Itoa(ai * bi)
			} else if token == "/" {
				res = strconv.Itoa(ai / bi)
			}
			stack = append(stack, res)
		} else {
			stack = append(stack, token)
		}
	}

	result, _ := strconv.Atoi(stack[len(stack)-1])
	return result
}
