package main

import "fmt"

/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
*/
// 超时写法
func minWindowOutTime(s string, t string) string {
	var l = 0
	runes := []rune(s)
	length := len(runes)
	var minLength = length + 1
	var result = ""

	var targetMap = make(map[int]int)
	for _, c := range t {
		targetMap[int(c)]++
	}
	var sourceMap = make([]int, 256)

	for i := 0; i < length; i++ {
		sourceMap[runes[i]]++
		// 判断现在source子串是否包含了target
		for sourceContainTarget(targetMap, sourceMap) {
			// 更新长度
			tempMinLength := min(minLength, i-l+1)
			if tempMinLength < minLength {
				minLength = tempMinLength
				result = string(runes[l : i+1])
			}
			// 窗口左边开始滑动
			sourceMap[runes[l]]--
			l++
		}
	}

	return result
}

func sourceContainTarget(targetMap map[int]int, sourceMap []int) bool {
	for r := range targetMap {
		if r2 := sourceMap[r]; r2 < targetMap[r] {
			return false
		}
	}
	return true
}

func minWindow(s string, t string) string {
	if len(t) == 0 || len(s) < len(t) {
		return ""
	}

	targetMap := make(map[byte]int)
	for i := 0; i < len(t); i++ {
		targetMap[t[i]]++
	}

	windowMap := make(map[byte]int)
	left, right := 0, 0
	matchCount := 0
	minLength := len(s) + 1
	start := 0

	// 使用 matchCount 来优化 并不需要每次都遍历两个map
	for right < len(s) {
		c := s[right]
		if _, ok := targetMap[c]; ok {
			windowMap[c]++
			if windowMap[c] == targetMap[c] {
				matchCount++
			}
		}

		for matchCount == len(targetMap) {
			//更新最小窗口
			if right-left+1 < minLength {
				start = left
				minLength = right - left + 1
			}
			d := s[left]
			if _, ok := targetMap[d]; ok {
				if windowMap[d] == targetMap[d] {
					matchCount--
				}
				windowMap[d]--
			}
			left++
		}
		right++
	}

	if minLength == len(s)+1 {
		return ""
	}
	return s[start : start+minLength]
}

func main() {
	fmt.Println(minWindow("ADOBECODEBANC", "ABC"))
}
