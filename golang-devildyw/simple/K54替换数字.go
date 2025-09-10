package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var (
		s      string
		length int
	)
	reader := bufio.NewReader(os.Stdin)
	s, _ = reader.ReadString('\n')
	bytes := []byte(s)
	length = len(bytes)
	result := make([]byte, 0)
	bytes = make([]byte, 0)

	for i := 0; i < length; i++ {
		if bytes[i] <= '9' && bytes[i] >= '0' {
			result = append(result, []byte("number")...)
		} else {
			result = append(result, bytes[i])
		}
	}

	fmt.Println(string(result))

}
