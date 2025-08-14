package main

func main() {

}

func isAnagram(s string, t string) bool {
	var (
		bytes = []byte(s)
		bytet = []byte(t)
		arr   = [26]int{}
	)

	for i := 0; i < len(bytes); i++ {
		arr[bytes[i]-'a']++
	}

	for i := 0; i < len(bytet); i++ {
		arr[bytet[i]-'a']--
	}

	for i := 0; i < len(arr); i++ {
		if arr[i] != 0 {
			return false
		}
	}
	return true
}
