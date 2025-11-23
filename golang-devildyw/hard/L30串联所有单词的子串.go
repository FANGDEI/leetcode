package main

import (
	"fmt"
)

func main() {
	// 测试用例
	s := "ababababab"
	words := []string{"ababa", "babab"}
	fmt.Printf("输入: s = %s, words = %v\n", s, words)
	fmt.Printf("输出: %v\n", findSubstring(s, words))

	//// 更复杂的测试用例
	//s2 := "wordgoodgoodgoodbestword"
	//words2 := []string{"word", "good", "best", "good"}
	//fmt.Printf("\n输入: s = %s, words = %v\n", s2, words2)
	//fmt.Printf("输出: %v\n", findSubstring(s2, words2))
}

func findSubstring(s string, words []string) []int {
	// 词频法
	if len(words) == 0 || len(s) == 0 {
		return []int{}
	}

	// 这里处理词频
	wordLen := len(words[0])
	totalWords := len(words)
	totalLen := wordLen * totalWords

	// 如果words 里面单词总长都大于了 s 的长度 那么肯定串联不了
	if totalLen > len(s) {
		return []int{}
	}

	// 计算词频
	targetFreq := make(map[string]int)
	for _, word := range words {
		targetFreq[word]++
	}

	var result []int

	// 从每个可能的位置开始滑动窗口
	for i := 0; i < wordLen; i++ {
		left := i
		right := i
		currentFreq := make(map[string]int)
		count := 0

		// 开始滑动
		for right+wordLen <= len(s) {
			// 获取单词
			word := s[right : right+wordLen]
			right += wordLen
			if value, exist := targetFreq[word]; exist {
				// 如果存在的话
				currentFreq[word]++
				count++
				// 如果词频大于了 words 中的词频 需要进行滑动
				for currentFreq[word] > value {
					leftWord := s[left : left+wordLen]
					currentFreq[leftWord]--
					left += wordLen
					count--
				}

				if count == totalWords {
					result = append(result, left)
					// 继续移动左边界 查找下一个
					leftWord := s[left : left+wordLen]
					currentFreq[leftWord]--
					left += wordLen
					count--

				}
				// 如果窗口中出现了不属于 words 中的字符串 那么直接重置窗口
			} else {
				currentFreq = make(map[string]int)
				count = 0
				left = right
			}
		}
	}
	return result
}
