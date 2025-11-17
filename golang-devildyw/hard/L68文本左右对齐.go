package main

import "fmt"

func main() {
	// 示例 1
	words1 := []string{"This", "is", "an", "example", "of", "text", "justification."}
	maxWidth1 := 16
	fmt.Println("示例 1:")
	result1 := fullJustify(words1, maxWidth1)
	for _, line := range result1 {
		fmt.Printf("[%s] len=%d\n", line, len(line))
	}
	fmt.Println()

	// 示例 2
	words2 := []string{"What", "must", "be", "acknowledgment", "shall", "be"}
	maxWidth2 := 16
	fmt.Println("示例 2:")
	result2 := fullJustify(words2, maxWidth2)
	for _, line := range result2 {
		fmt.Printf("[%s] len=%d\n", line, len(line))
	}
	fmt.Println()

	// 示例 3
	words3 := []string{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}
	maxWidth3 := 20
	fmt.Println("示例 3:")
	result3 := fullJustify(words3, maxWidth3)
	for _, line := range result3 {
		fmt.Printf("[%s] len=%d\n", line, len(line))
	}
}

func fullJustify(words []string, maxWidth int) []string {
	result := make([]string, 0)
	i := 0

	for i < len(words) {
		// 贪心地将单词放入当前行
		lineWords := make([]string, 0)
		lineLen := 0

		// 计算当前行能放多少个单词
		for i < len(words) {
			// 如果加上这个单词和必需的空格后超过maxWidth，就不加了
			if lineLen+len(words[i])+len(lineWords) > maxWidth {
				break
			}
			lineWords = append(lineWords, words[i])
			lineLen += len(words[i])
			i++
		}

		// 判断是否是最后一行
		isLastLine := i == len(words)
		line := buildLine(lineWords, maxWidth, lineLen, isLastLine)
		result = append(result, line)
	}

	return result
}

// 构造一行文本
func buildLine(words []string, maxWidth, wordsLen int, isLastLine bool) string {
	// 最后一行：左对齐，单词间只有一个空格
	if isLastLine {
		line := ""
		for i, word := range words {
			line += word
			if i < len(words)-1 {
				line += " "
			}
		}
		// 右边填充空格
		for len(line) < maxWidth {
			line += " "
		}
		return line
	}

	// 只有一个单词：左对齐，右边填充空格
	if len(words) == 1 {
		line := words[0]
		for len(line) < maxWidth {
			line += " "
		}
		return line
	}

	// 普通行：左右对齐
	totalSpaces := maxWidth - wordsLen // 总共需要的空格数
	gaps := len(words) - 1             // 单词间的间隙数
	spacePerGap := totalSpaces / gaps  // 每个间隙的基本空格数
	extraSpaces := totalSpaces % gaps  // 额外的空格数（要分配到左边）

	line := ""
	for i, word := range words {
		line += word
		if i < len(words)-1 {
			// 添加基本空格
			for j := 0; j < spacePerGap; j++ {
				line += " "
			}
			// 左边的间隙多加一个空格
			if i < extraSpaces {
				line += " "
			}
		}
	}

	return line
}
