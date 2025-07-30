package main

func TotalFruit(fruits []int) int {
	// 找到最长的子串 这个子串里面只有两种数字
	l := 0
	length := len(fruits)
	result := -1
	fruitMap := make(map[int]int)
	for i := 0; i < length; i++ {
		fruitMap[fruits[i]]++
		for len(fruitMap) > 2 {
			fruitMap[fruits[l]]--
			v := fruitMap[fruits[l]]
			if v == 0 {
				delete(fruitMap, fruits[l])
			}
			l++
		}
		result = max(result, i-l+1)
	}

	return result
}
