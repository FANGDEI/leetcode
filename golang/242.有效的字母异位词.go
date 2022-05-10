package golang

import "reflect"

// water
func isAnagram(s string, t string) bool {
	sMap := map[string]int{}
	tMap := map[string]int{}
	for _, v := range s {
		sMap[string(v)]++
	}
	for _, v := range t {
		tMap[string(v)]++
	}
	return reflect.DeepEqual(sMap, tMap)
}
