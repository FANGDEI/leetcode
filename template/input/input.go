package input

import (
	"bufio"
	"io"
	"strings"
)

var scanner *bufio.Scanner

func new(reader io.Reader) {
	scanner = bufio.NewScanner(reader)
	bs := make([]byte, 20000*1024)
	scanner.Buffer(bs, len(bs))
}

func readLine() []string {
	scanner.Scan()
	return strings.Split(scanner.Text(), " ")
}
