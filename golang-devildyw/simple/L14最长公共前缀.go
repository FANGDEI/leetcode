package main

func main() {
	longestCommonPrefix([]string{"flower", "flow", "flight"})
}

// todo 后面考虑字典树 做一下
func longestCommonPrefix(strs []string) string {
	// 找出字符串数组里面最小的长度
	minLen := len(strs[0])
	result := ""

	for _, str := range strs {
		minLen = min(minLen, len(str))
	}

	for i := 0; i < minLen; i++ {
		str := strs[0][i]
		flag := true
		for _, s := range strs {
			if str == s[i] {
				continue
			} else {
				flag = false
				break
			}
		}
		if !flag {
			break
		}
		result += string(str)
	}

	return result
}
