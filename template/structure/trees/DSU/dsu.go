package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

const (
	N = 30005
)

var (
	m, n    int
	fa      [N]int
	scanner *bufio.Scanner
)

func Init() {
	for i := 0; i < N; i++ {
		fa[i] = i
	}
}

func Find(x int) int {
	if fa[x] == x {
		return x
	}
	fa[x] = Find(fa[x])
	return fa[x]
}

func Union(x, y int) {
	fx := Find(x)
	fy := Find(y)
	if fx != fy {
		fa[fx] = fy
	}
}

func main() {
	new(os.Stdin)
	in := readLine()
	n, _ = strconv.Atoi(in[0])
	m, _ = strconv.Atoi(in[1])

	for n+m != 0 {
		Init()
		for i := 1; i <= m; i++ {
			in = readLine()
			k, _ := strconv.Atoi(in[0])
			a, _ := strconv.Atoi(in[1])
			for j := 2; j <= k; j++ {
				b, _ := strconv.Atoi(in[j])
				Union(a, b)
			}
		}
		res := 1
		for i := 1; i <= n; i++ {
			if Find(i) == Find(0) {
				res++
			}
		}
		fmt.Println(res)

		in := readLine()
		n, _ = strconv.Atoi(in[0])
		m, _ = strconv.Atoi(in[1])
	}
}

func new(reader io.Reader) {
	scanner = bufio.NewScanner(reader)
	bs := make([]byte, 20000*1024)
	scanner.Buffer(bs, len(bs))
}

func readLine() []string {
	scanner.Scan()
	return strings.Split(scanner.Text(), " ")
}
