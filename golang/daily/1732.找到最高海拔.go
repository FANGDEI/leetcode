package daily

// 前缀和
func largestAltitude(gain []int) int {
	s, ret := 0, 0
	for i := 0; i < len(gain); i++ {
		s += gain[i]
		if s > ret {
			ret = s
		}
	}
	return ret
}
