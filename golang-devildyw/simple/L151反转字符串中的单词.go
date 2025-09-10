package main

import "strings"

func main() {
	println(reverseWords("a good   example"))
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
