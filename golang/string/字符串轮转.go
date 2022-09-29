package string

import "strings"

func isFlipedString(s1 string, s2 string) bool {
    if len(s1) != len(s2) {
        return false
    }
    tmp := s2 + s2
	return strings.Contains(tmp, s1)
}