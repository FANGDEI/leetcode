package main

func main() {
	wordPattern("abba", "dog cat cat fish")
}

func wordPattern(pattern string, s string) bool {
	sSplit := make([]string, 0)

	start := 0
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			sSplit = append(sSplit, string(s[start:i]))
			start = i + 1
		}
	}

	if start < len(s) {
		sSplit = append(sSplit, string(s[start:]))
	}
	if len(sSplit) != len(pattern) {
		return false
	}

	PHash := make(map[byte]string)
	SHash := make(map[string]byte)

	for i := 0; i < len(pattern); i++ {
		if value, exist := PHash[pattern[i]]; exist {
			if value != sSplit[i] {
				return false
			}
		} else {
			PHash[pattern[i]] = sSplit[i]
		}

		if value, exist := SHash[sSplit[i]]; exist {
			if value != pattern[i] {
				return false
			}
		} else {
			SHash[sSplit[i]] = pattern[i]
		}
	}
	return true

}
