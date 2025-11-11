package main

import "strings"

func main() {
	println(reverseWords_01("the sky is blue"))
}

func reverseWords(s string) string {
	s = strings.Trim(s, " ")
	var builder strings.Builder

	stringLists := make([]string, 0)
	bytes := []byte(s)
	for i := 0; i < len(bytes); i++ {
		if bytes[i] == ' ' {
			continue
		} else {
			start := i
			for ; i < len(bytes); i++ {
				if bytes[i] == ' ' {
					stringLists = append(stringLists, string(bytes[start:i]))
					break
				} else {
					if i == len(bytes)-1 {
						stringLists = append(stringLists, string(bytes[start:i+1]))
					}
				}
			}
		}
	}

	for i, j := 0, len(stringLists)-1; i < j; i, j = i+1, j-1 {
		stringLists[i], stringLists[j] = stringLists[j], stringLists[i]
	}

	for i := 0; i < len(stringLists); i++ {
		builder.WriteString(stringLists[i])
		if i != len(stringLists)-1 {
			builder.WriteString(" ")
		}
	}

	return builder.String()
}

/*
在原来字符串上修改
*/
func reverseWords_new(s string) string {
	s = strings.Trim(s, " ")

	// 先过滤掉单词之间的空格
	b := []byte(s)
	slowIndex, fastIndex := 0, 0
	for ; fastIndex < len(s); fastIndex++ {
		if fastIndex-1 > 0 && b[fastIndex-1] == b[fastIndex] && b[fastIndex] == ' ' {
			continue
		}
		b[slowIndex] = b[fastIndex]
		slowIndex++
	}

	// 删除尾部冗余空格
	if slowIndex-1 > 0 && b[slowIndex-1] == ' ' {
		b = b[:slowIndex-1]
	} else {
		b = b[:slowIndex]
	}

	// 反转整个字符串
	reverseStr(b)

	// 单独反转单个单词
	i := 0
	for i < len(b) {
		j := i
		// 碰到空格才退出循环
		for ; j < len(b) && b[j] != ' '; j++ {
		}
		reverseStr(b[i:j])
		i = j
		i++
	}
	return string(b)
}

func reverseStr(b []byte) {
	left, right := 0, len(b)-1
	for left < right {
		b[left], b[right] = b[right], b[left]
		left++
		right--
	}
}

func reverseWords_01(s string) string {
	// 先去除字符串两变的空格
	s = strings.Trim(s, " ")

	bytes := make([]byte, len(s))
	// 删除单词间的空格 使其保持在一个 快慢指针
	slowIndex := 0
	for i := 0; i < len(s); i++ {
		if i-1 > 0 && s[i-1] == ' ' && s[i] == ' ' {
			continue
		} else {
			bytes[slowIndex] = s[i]
			slowIndex++
		}
	}

	bytes = bytes[:slowIndex]

	// 反转整个字符串
	reverseStr(bytes)

	// 找单词 然后反转
	start := 0
	for i := 0; i < len(bytes); i++ {
		if bytes[i] == ' ' {
			reverseStr(bytes[start:i])
			i++
			start = i
		}
	}

	reverseStr(bytes[start:])
	return string(bytes[:])
}
