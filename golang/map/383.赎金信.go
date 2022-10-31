package map_set

func canConstruct(ransomNote string, magazine string) bool {
	m := map[uint8]int{}
	for i := 0; i < len(magazine); i++ {
		m[magazine[i]]++
	}

	for i := 0; i < len(ransomNote); i++ {
		m[magazine[i]]--
		if cnt := m[magazine[i]]; cnt < 0 {
			return false
		}
	}
	return true
}
