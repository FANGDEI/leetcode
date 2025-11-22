package main

import (
	"fmt"
)

func main() {
	// 测试用例
	s := "barfoothefoobarman"
	words := []string{"foo", "bar"}
	fmt.Printf("输入: s = %s, words = %v\n", s, words)
	fmt.Printf("输出: %v\n", findSubstring(s, words))

	// 更复杂的测试用例
	s2 := "wordgoodgoodgoodbestword"
	words2 := []string{"word", "good", "best", "good"}
	fmt.Printf("\n输入: s = %s, words = %v\n", s2, words2)
	fmt.Printf("输出: %v\n", findSubstring(s2, words2))
}

func findSubstring(s string, words []string) []int {
	if len(words) == 0 || len(s) == 0 {
		return []int{}
	}

	wordLen := len(words[0])
	totalWords := len(words)
	totalLen := wordLen * totalWords

	if totalLen > len(s) {
		return []int{}
	}

	// 构建目标词频映射
	targetFreq := make(map[string]int)
	for _, word := range words {
		targetFreq[word]++
	}

	var result []int

	// 对每个可能的起始位置进行滑动窗口
	for i := 0; i < wordLen; i++ {
		left := i
		right := i
		currentFreq := make(map[string]int)
		count := 0

		for right+wordLen <= len(s) {
			// 获取当前单词
			word := s[right : right+wordLen]
			right += wordLen

			// 如果单词在目标中
			if val, exists := targetFreq[word]; exists {
				currentFreq[word]++
				count++

				// 如果当前单词出现次数超过目标，移动左边界
				for currentFreq[word] > val {
					leftWord := s[left : left+wordLen]
					currentFreq[leftWord]--
					left += wordLen
					count--
				}

				// 如果找到匹配
				if count == totalWords {
					result = append(result, left)

					// 移动左边界继续寻找下一个可能的匹配
					leftWord := s[left : left+wordLen]
					currentFreq[leftWord]--
					left += wordLen
					count--
				}
			} else {
				// 单词不在目标中，重置窗口
				currentFreq = make(map[string]int)
				count = 0
				left = right
			}
		}
	}

	return result
}
