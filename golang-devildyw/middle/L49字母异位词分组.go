package main

import "sort"

func main() {

}

func groupAnagrams(strs []string) [][]string {
	if len(strs) == 1 {
		return [][]string{strs}
	}
	result := make([][]string, 0)
	// 对每个单词排序 这个挺耗时的吧 感觉
	m := make(map[string][]string)
	for _, str := range strs {
		// 对 str 排序
		bytes := []byte(str)
		sort.Slice(bytes, func(i, j int) bool {
			return bytes[i] < bytes[j]
		})

		newStr := string(bytes)

		if value, exist := m[newStr]; exist {
			value = append(value, str)
			m[newStr] = value
		} else {
			strList := []string{str}
			m[newStr] = strList
		}
	}

	for _, value := range m {
		result = append(result, value)
	}
	return result
}
