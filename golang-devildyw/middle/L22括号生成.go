package main

func main() {

}

// 笨方法了属于是
func generateParenthesis(n int) []string {
	result := make([]string, 0)
	stack := make([]byte, 0)
	path := []byte{}
	var backtracking func(count int)
	backtracking = func(count int) {
		if len(path) == 2*n && count == n {
			result = append(result, string(path))
			return
		}
		if len(path) >= 2*n || count > n {
			return
		}
		// 栈只存储括号的左边
		// 无非就两种情况 要么栈大于0 要么栈小于0 小于0时只能填入括号左边 这没办法的
		if len(stack) > 0 {
			// 大于0时也分情况
			// 要么继续加入括号左边、要么左括号出栈完成一个括号的闭环
			// 1. 继续加入括号左边
			stack = append(stack, '(')
			path = append(path, '(')
			backtracking(count)
			stack = stack[:len(stack)-1]
			path = path[:len(path)-1]

			// 2. 出栈 括号闭合
			stack = stack[:len(stack)-1]
			path = append(path, ')')
			backtracking(count + 1)
			// 【必须补上】：回溯！把刚才出栈的元素加回来，把加进去的路径删掉
			stack = append(stack, '(') // 恢复：把刚才删掉的左括号加回去
			path = path[:len(path)-1]  // 恢复：把刚才加的右括号删掉
		} else {
			stack = append(stack, '(')
			path = append(path, '(')
			backtracking(count)
			// 【必须补上】：回溯！把刚才出栈的元素加回来，把加进去的路径删掉
			stack = stack[:len(stack)-1] // 恢复
			path = path[:len(path)-1]    // 恢复：把刚才加的右括号删掉
		}
	}
	backtracking(0)

	return result
}

func generateParenthesisNew(n int) []string {
	result := make([]string, 0)

	var backtracking func(path string, open, close int)
	// 不使用栈 但是可以用栈的一些思想来做这个题 open 代表左括号 close代表右括号
	backtracking = func(path string, open, close int) {
		// close > open 一个是保证了close一定是再open后面添加 另一个就是保证左右括号能闭合
		// 这个判断可以避免 ')(' '())'的情况
		if open > n || close > open {
			return
		}

		if len(path) == 2*n {
			result = append(result, path)
			return
		}

		if open < n {
			// 只要 open 小于 n 那么就可以填左括号
			backtracking(path+"(", open+1, close)
		}

		if close < open {
			// 只要close小于open就可以添右括号
			backtracking(path+")", open, close+1)
		}
	}
	backtracking("", 0, 0)
	return result
}
