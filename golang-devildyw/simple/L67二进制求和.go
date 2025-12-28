package main

func main() {

}

func addBinary(a string, b string) string {
	// 加减进位罢了
	var c int
	result := make([]byte, 0)
	aIndex, bIndex := len(a)-1, len(b)-1
	for aIndex >= 0 || bIndex >= 0 || c > 0 {
		aVal, bVal := 0, 0
		if aIndex >= 0 {
			aVal = int(a[aIndex] - '0')
			aIndex--
		}

		if bIndex >= 0 {
			bVal = int(b[bIndex] - '0')
			bIndex--
		}

		sum := aVal + bVal + c
		result = append(result, byte(sum%2+'0'))
		c = sum / 2
	}
	reverseBytes(result)
	return string(result)
}

func reverseBytes(bytes []byte) {
	for i, j := 0, len(bytes)-1; i < j; i, j = i+1, j-1 {
		bytes[i], bytes[j] = bytes[j], bytes[i]
	}
}
