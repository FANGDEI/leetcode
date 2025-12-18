package main

func main() {}

func letterCombinations(digits string) []string {
	var paths []string
	m := map[byte][]byte{
		'2': {'a', 'b', 'c'},
		'3': {'d', 'e', 'f'},
		'4': {'g', 'h', 'i'},
		'5': {'j', 'k', 'l'},
		'6': {'m', 'n', 'o'},
		'7': {'p', 'q', 'r', 's'},
		'8': {'t', 'u', 'v'},
		'9': {'w', 'x', 'y', 'z'},
	}

	var backtrack func(index int, current []byte)
	backtrack = func(index int, current []byte) {
		if index == len(digits) {
			paths = append(paths, string(current))
			return
		}

		letters := m[digits[index]]
		for i := 0; i < len(letters); i++ {
			backtrack(index+1, append(current, letters[i]))
		}
	}
	backtrack(0, []byte{})
	return paths
}
