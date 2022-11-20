package string

import "strings"

func replaceSpace(s string) string {
	tmp := strings.Builder{}
	for _, v := range s {
		if v == ' ' {
			tmp.WriteString("%20")
		} else {
			tmp.WriteByte(byte(v))
		}
	}
	return tmp.String()
}
