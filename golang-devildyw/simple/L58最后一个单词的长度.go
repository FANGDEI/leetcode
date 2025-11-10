package main

func main() {
	lengthOfLastWord("Hello World")
}

func lengthOfLastWord(s string) int {
	var (
		bytes  = []byte(s)
		n      = len(bytes)
		result = 0
	)

	idx := 0
	for i := n - 1; i >= 0; i-- {
		if bytes[i] == ' ' {
			continue
		} else {
			idx = i
			break
		}
	}

	for ; idx >= 0; idx-- {
		if bytes[idx] == ' ' {
			break
		}
		result++
	}
	return result
}
