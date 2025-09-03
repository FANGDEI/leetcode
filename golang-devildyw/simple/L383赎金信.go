package main

func main() {

}

func canConstruct(ransomNote string, magazine string) bool {

	var (
		nums [26]int = [26]int{}
	)

	for _, c := range ransomNote {
		nums[c-'a']++
	}

	for _, c := range magazine {
		if nums[c-'a'] > 0 {
			nums[c-'a']--
		}
	}

	for _, num := range nums {
		if num > 0 {
			return false
		}
	}
	return true
}
