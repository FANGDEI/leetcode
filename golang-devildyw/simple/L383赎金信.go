package main

func main() {

}

func canConstruct(ransomNote string, magazine string) bool {
	var (
		hash = make([]int, 26)
	)

	for i := 0; i < len(magazine); i++ {
		hash[magazine[i]-'a']++
	}

	for i := 0; i < len(ransomNote); i++ {
		if hash[ransomNote[i]-'a'] <= 0 {
			return false
		}
		hash[ransomNote[i]-'a']--
	}
	return true
}
