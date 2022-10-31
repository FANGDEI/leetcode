package map_set

func canConstruct(ransomNote string, magazine string) bool {
	m := map[byte]int{}
	for i := 0; i < len(magazine); i++ {
		m[byte(magazine[i])]++
	}

	for i := 0; i < len(ransomNote); i++ {
		m[byte(ransomNote[i])]--
		if cnt := m[byte(ransomNote[i])]; cnt < 0 {
			return false
		}
	}
	return true
}