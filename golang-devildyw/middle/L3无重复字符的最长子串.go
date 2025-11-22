package main

func main() {

}

// 滑动窗口罢了
func lengthOfLongestSubstring(s string) int {
	mapp := make(map[byte]struct{})
	result := 0
	left := 0
	for i := 0; i < len(s); i++ {
		for {
			if _, ok := mapp[s[i]]; ok {
				delete(mapp, s[left])
				left++
			} else {
				break
			}
		}
		mapp[s[i]] = struct{}{}
		result = max(result, i-left+1)
	}

	return result
}
