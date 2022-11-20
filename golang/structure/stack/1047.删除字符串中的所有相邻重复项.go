package stack

import (
	"leetcode/tools"
	"strings"
)

// b题的数据范围乱给?
func removeDuplicates(s string) string {
	stack, top := [50000]byte{}, -1

	for i := 0; i < len(s); i++ {
		if top == -1 || stack[top] != s[i] {
			top++
			stack[top] = s[i]
		} else {
			top--
		}
	}

	ret := strings.Builder{}
	for ; top != -1; top-- {
		ret.WriteByte(stack[top])
	}

	return tools.Reverse(ret.String())
}
