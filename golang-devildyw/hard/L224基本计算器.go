package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(calculateTest("(1+(4+5+2)-3)+(6+8)"))
}

func calculate(s string) int {
	// 存放所有数字
	nums := make([]int, 0)
	// 为了防止第一个数为负数，先往 nums 中加个0 (例如 "-1+2")
	nums = append(nums, 0)

	// 去掉空格
	s = strings.ReplaceAll(s, " ", "")

	// 存放操作符
	ops := make([]byte, 0)

	// 定义 calc 为闭包，直接修改外部的 nums 和 ops
	calc := func() {
		if len(nums) < 2 {
			return
		}
		if len(ops) == 0 {
			return
		}

		// 弹出两个数字
		b := nums[len(nums)-1]
		nums = nums[:len(nums)-1]
		a := nums[len(nums)-1]
		nums = nums[:len(nums)-1]

		// 弹出一个操作符
		op := ops[len(ops)-1]
		ops = ops[:len(ops)-1]

		var res int
		if op == '+' {
			res = a + b
		} else {
			res = a - b
		}
		nums = append(nums, res)
	}

	n := len(s)
	for i := 0; i < n; i++ {
		c := s[i]

		if c == '(' {
			ops = append(ops, c)
		} else if c == ')' {
			// 修正2：循环条件逻辑修正
			// 计算直到遇到最近的 '('
			for len(ops) > 0 {
				op := ops[len(ops)-1]
				if op != '(' {
					calc()
				} else {
					// 弹出 '(' 并结束
					ops = ops[:len(ops)-1]
					break
				}
			}
		} else if isNum(c) {
			u := 0
			j := i
			for j < n && isNum(s[j]) {
				u = u*10 + int(s[j]-'0')
				j++
			}
			nums = append(nums, u)
			i = j - 1
		} else {
			// 是 + 或 -
			// 修正3：运算优先级与越界保护
			// 如果前一个是 '(', 说明出现了 '(-2)' 这种情况，需要补0变为 '(0-2)'
			// 只需要判断 '(' 即可，因为开头已经补了0，且题目通常不包含 '++' '--' 等情况
			if i > 0 && s[i-1] == '(' {
				nums = append(nums, 0)
			}

			// 栈内只要不是 '('，就一直计算 (因为 + - 优先级相同，从左往右算)
			for len(ops) > 0 && ops[len(ops)-1] != '(' {
				calc()
			}

			// 修正4：必须将当前操作符入栈！
			ops = append(ops, c)
		}
	}

	// 计算剩余的操作
	for len(ops) > 0 {
		calc()
	}

	return nums[len(nums)-1]
}

func isNum(c byte) bool {
	return c >= '0' && c <= '9'
}

func calculateTest(s string) int {
	// 第一个栈用来存放过程中的数字
	nums := make([]int, 0)
	// 防止第一个数字是负数 所以前置一个0 0减一个数不就是负数吗
	nums = append(nums, 0)
	// 第二个栈用来存放操作符
	ops := make([]byte, 0)
	// 清空 s中的空格
	s = strings.ReplaceAll(s, " ", "")
	//开始遍历
	for i := 0; i < len(s); i++ {
		c := s[i]
		if c == '(' {
			ops = append(ops, c)
		} else if c == ')' {
			// 计算括号内的内容 直到遇到'('
			for len(ops) > 0 {
				op := ops[len(ops)-1]
				if op != '(' {
					calc(&nums, &ops)
				} else {
					ops = ops[:len(ops)-1]
					break
				}
			}
		} else {
			if isNum(c) {
				u := 0
				j := i
				for j < len(s) && isNum(s[j]) {
					u = u*10 + int(s[j]-'0')
					j++
				}
				nums = append(nums, u)
				i = j - 1
			} else {
				// 这里也是这样处理
				if i > 0 && s[i-1] == '(' {
					nums = append(nums, 0)
				}

				for len(ops) > 0 && ops[len(ops)-1] != '(' {
					calc(&nums, &ops)
				}
				ops = append(ops, c)
			}
		}
	}

	for len(ops) > 0 {
		calc(&nums, &ops)
	}

	return nums[len(nums)-1]
}

func calc(nums *[]int, ops *[]byte) {
	if len(*nums) == 0 || len(*nums) < 2 {
		return
	}
	if len(*ops) == 0 {
		return
	}

	//取出元素
	b := (*nums)[len(*nums)-1]
	*nums = (*nums)[:len(*nums)-1]
	a := (*nums)[len(*nums)-1]
	*nums = (*nums)[:len(*nums)-1]
	op := (*ops)[len(*ops)-1]
	var res int
	if op == '+' {
		res = a + b
	} else {
		res = a - b
	}
	*nums = append(*nums, res)
	*ops = (*ops)[:len(*ops)-1]
}
