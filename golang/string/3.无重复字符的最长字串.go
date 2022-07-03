package string

import (
	"leetcode/tools"
)

// 双指针 + map
// map用来记录当前序列每个字符出现的次数
// 当map中的记录大于一时说明当前序列出现重复
// 移动指针直到重复字符消失即可
func lengthOfLongestSubstring(s string) int {
	a := map[byte]int{}
	res := 0
	for i, j := 0, 0; i < len(s); i++ {
		a[s[i]]++
		for j <= i && a[s[i]] > 1 {
			a[s[j]]--
			j++
		}
		res = tools.Max(res, i-j+1)
	}
	return res
}
