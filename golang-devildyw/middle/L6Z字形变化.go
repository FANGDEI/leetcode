package main

import "strings"

func main() {

}

func convert(s string, numRows int) string {
	// 模拟 我们不用真正去吧字符串变成一个z字形填充到数组中 我们只需要知道当前时刻字符在哪一行即可 分别维护每一行的字符串 最终拼起来即可
	// 判断边界条件 只有一行或字符串长度小于等于行数时
	if numRows == 1 || len(s) <= numRows {
		return s
	}

	// 为每一行创建一个字符串构建器
	rows := make([]strings.Builder, numRows)
	curRow := 0        //当前索引行
	goingDown := false // 方向标志

	// 遍历字符串串中的每个字符
	for _, char := range s {
		rows[curRow].WriteRune(char)

		// 当在第一行或者最后一行时改变goingdown方向
		if curRow == 0 || curRow == numRows-1 {
			goingDown = !goingDown
		}

		if goingDown {
			curRow++
		} else {
			curRow--
		}

	}

	// 最后把每一层字符串拼起来
	var result strings.Builder
	for i := 0; i < numRows; i++ {
		result.WriteString(rows[i].String())
	}

	return result.String()
}
