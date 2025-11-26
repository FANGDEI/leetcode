package main

func main() {
	isIsomorphic("badc", "baba")
}

// 题目问题 要求应该 s到t是1对1 t到s也是1对1
func isIsomorphic(s string, t string) bool {
	var (
		sHash = make(map[byte]byte)
		THash = make(map[byte]byte)
		n     = len(s)
	)

	for i := 0; i < n; i++ {
		if value, exist := sHash[s[i]]; exist {
			if value != t[i] {
				return false
			}
		} else {
			sHash[s[i]] = t[i]
		}

		if value, exist := THash[t[i]]; exist {
			if value != s[i] {
				return false
			}
		} else {
			THash[t[i]] = s[i]
		}
	}
	return true
}
