package main

func main() {

}

func reverseString(s []byte) {
	var (
		left, right int = 0, len(s) - 1
	)

	for ; left < right; left, right = left+1, right-1 {
		s[left], s[right] = s[right], s[left]
	}
}
